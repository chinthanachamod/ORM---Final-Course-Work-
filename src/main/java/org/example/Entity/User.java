
package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class User {
    @Id
    private String user_id;
    private String username;
    private String Address;
    private String user_phone;
    private String user_email;
    private String Position;
    private String password;
}
