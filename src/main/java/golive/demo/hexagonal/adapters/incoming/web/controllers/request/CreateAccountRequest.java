package golive.demo.hexagonal.adapters.incoming.web.controllers.request;


import lombok.Data;

@Data
public class CreateAccountRequest {
    private String name;
    private String address;
}
