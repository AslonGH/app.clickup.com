package uz.pdp.springbootprojectprocesses.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class JwtProvider {

   private static final long expireTime = 1000 * 60 * 60 * 24;   // 1 KUN
   private static final String  secretSoz = "maxfiysozbunihechkimbilmasin";

   // TOKENNI GENERATION QILISH
   public String generateToken(String username){
      Date expireDate = new Date(System.currentTimeMillis() + expireTime);
      String token = Jwts
              .builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(expireDate)
              .signWith(SignatureAlgorithm.HS512,secretSoz) // XATOLIK BERGANDA: ÖRNINI ALASHTIRDIM;SECRET SÖZNI QAYTA YOZ....
              .compact();
      return  token;
   }


   // CLIENT 2-MARTA TOKEN BILAN KIRGANDA TOKEN ICHIDAN EMAIL NI OLISH
   public String getEmailFromToken(String token){

        try {
           String email = Jwts
                   .parser()
                   .setSigningKey(secretSoz)
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
           return email;
           // QANAQA XATOLIK BÖLSA HAM CATCH GA TUSHADI; MASALAN ExpiredDate bölsa ham.
        }catch (Exception e){
           return null;
        }
   }




}
