package com.example.beproduct.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class output {
    HttpStatus httpStatus;
    String message;
}
