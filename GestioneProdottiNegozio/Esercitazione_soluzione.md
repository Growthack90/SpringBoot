# **Database**

```sql
CREATE DATABASE IF NOT EXISTS negozio;

USE negozio;

CREATE TABLE IF NOT EXISTS prodotti (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
prezzo DECIMAL(10,2) NOT NULL,
quantita INT NULL DEFAULT 0,
categoria VARCHAR(255) NULL DEFAULT 'Nessuna categoria'
);

DESC prodotti;

INSERT INTO prodotti (nome, prezzo, quantita, categoria) VALUES
('Laptop ASUS', 999.99, 10, 'Elettronica'),
('Smartphone Samsung', 599.99, 15, 'Telefonia'),
('Monitor LG', 249.99, 5, 'Elettronica'),
('Tastiera meccanica', 79.99, 20, 'Periferiche'),
('Mouse gaming', 49.99, 30, 'Periferiche'),
('Stampante Epson', 149.99, 8, 'Ufficio'),
('Cuffie Bluetooth', 89.99, 25, 'Audio'),
('Hard Disk esterno 1TB', 109.99, 12, 'Archiviazione'),
('Smartwatch Apple', 399.99, 7, 'Telefonia'),
('Router TP-Link', 59.99, 18, 'Reti');

SELECT * FROM prodotti;
```

## `Prodotto`

```java
package com.example.demo.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prodotti")
public class Prodotto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nome", nullable = false, length = 255)
private String nome;

@Column(name = "prezzo", nullable = false, precision = 10, scale = 2)
private BigDecimal prezzo;

@Column(name = "quantita", nullable = true, columnDefinition = "INT DEFAULT 0")
private Integer quantita;

@Column(name = "categoria", length = 255, nullable = true, columnDefinition = "VARCHAR(255) DEFAULT 'Nessuna categoria'")
private String categoria;

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public BigDecimal getPrezzo() {
return prezzo;
}

public void setPrezzo(BigDecimal prezzo) {
this.prezzo = prezzo;
}

public Integer getQuantita() {
return quantita;
}

public void setQuantita(Integer quantita) {
this.quantita = quantita;
}

public String getCategoria() {
return categoria;
}

public void setCategoria(String categoria) {
this.categoria = categoria;
}

}
```

---

## `ProdottoRepository`

```java
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
```

---

## **`ProdottoController`**

```java
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Prodotto;
import com.example.demo.repositories.ProdottoRepository;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

@Autowired
private ProdottoRepository pr;

@GetMapping("/test")
public String test() {
return "ok";
}

@GetMapping("/")
public List<Prodotto> all() {
List<Prodotto> prodotti = pr.findAll();
System.out.println(prodotti);

return prodotti;
}
}
```

### Richiesta:

```http
GET http://localhost:8080/api/prodotti/
```

---