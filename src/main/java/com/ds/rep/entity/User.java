// package com.ds.rep.entity;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;

// @Entity
// @Data
// @AllArgsConstructor
// @Table(name = "chat")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "username")
//     private String username;

//     @Column(name = "password")
//     private String password;

//     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Chat> chats;
// }
