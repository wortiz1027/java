package co.com.demo.clients.domain.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements java.io.Serializable {

    private String id;
    private String dni;
    private String name;
    private String email;
    private String phone;

}
