package com.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    @Size(min = 3, message = "Name must contain at least 3 characters")
    private String fullName; //Not Null

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email; //	String	Not Null, Unique

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must contain exactly 10 digits")
    private String mobile;//	String	Not Null

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 100, message = "Age cannot exceed 100")
    private Integer age; //	Integer	Not Null

    @NotBlank(message = "Course is required")
    private String course;//	String	Not Null

    private LocalDateTime createdAt; //	LocalDateTime	Automatically populated
    private LocalDateTime updatedAt; //	LocalDateTime	Automatically populated

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
