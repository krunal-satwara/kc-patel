package com.krunal.kcpatel.util;

import com.krunal.kcpatel.entity.Role;
import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.entity.UserAgent;
import com.krunal.kcpatel.entity.UserNavigation;
import com.krunal.kcpatel.repository.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserNavigationRepository userNavigationRepository;

    @Autowired
    private UserAgentRepository userAgentRepository;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        try {
            User user = userRepository.findByUserEmailAndStatusIsTrue(userDetails.getUsername());
            claims.put("userId", user.getUserId());
            claims.put("view", false);
            claims.put("edit", false);
            claims.put("del", false);
            Role role = roleRepository.findByRoleId(user.getRoleId());
            claims.put("roleName", role.getRoleName());
            List<UserNavigation> userNavigations = userNavigationRepository.findAllByUserId(user.getUserId());
            if(userNavigations != null){
                String write = "";
                for (UserNavigation userNavigation:userNavigations) {
                    write += userNavigation.getNavigationUrl()+",";
                }
                claims.put("write", write);
            } else {
                claims.put("write", "false");
            }
            List<UserAgent> userAgentList = userAgentRepository.findAllByUserId(user.getUserId());
            if(userAgentList != null) {
                String agent = "";
                String agentId = "";
                for (UserAgent userAgent:userAgentList) {
                    agent += userAgent.getAgentCode()+",";
                    agentId += userAgent.getAgentId();
                }
                claims.put("agent", agent);
                claims.put("agentId", agentId);
            } else {
                claims.put("agent", "false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
