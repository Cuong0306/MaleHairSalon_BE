package com.BE.service;


import com.BE.model.entity.User;
import com.BE.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTService {

    private final String SECRET_KEY = "HT4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";

    @Value("${spring.duration}")
    private long DURATION;




    String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(Date.from(Instant.now()))
                .expirationTime(Date.from(Instant.now().plus(DURATION, ChronoUnit.SECONDS)))
                .claim("scope", "ROLE_" + user.getRole())
                .build();


        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
    @Bean
    public JwtDecoder jwtDecoder(){
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(),"HS512");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
    }



    public String getRefreshClaim(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);

            MACVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());
            if (!jwsObject.verify(verifier)) {
                throw new RuntimeException("Invalid token signature");
            }
            JWTClaimsSet claimsSet = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());

            return claimsSet.getStringClaim("refresh");
        } catch (ParseException | JOSEException e) {
            throw new RuntimeException("Error parsing token", e);
        }
    }

    public String verifyToken (String token) {
            try {
                // Parse the token
                JWSObject jwsObject = JWSObject.parse(token);

                // Verify the token's signature
                MACVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());
                if (!jwsObject.verify(verifier)) {
                    throw new RuntimeException("Invalid token signature");
                }

                // Extract claims
                JWTClaimsSet claimsSet = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());

                // Retrieve the email from the claims
                return claimsSet.getSubject(); // Assuming the email is stored in the subject
            } catch (ParseException | JOSEException e) {
                throw new RuntimeException("Error parsing token", e);
            }
        }
    }







