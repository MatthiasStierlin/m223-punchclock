package ch.zli.m223.punchclock.security;

/**
 * SecurityConstants
 *
 * @author Matthias Stierlin
 * @version 15.11.2020
 */
public class SecurityConstants {

    public static final String SECRET = "SecretKeyGenJTWs" ;
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
}


