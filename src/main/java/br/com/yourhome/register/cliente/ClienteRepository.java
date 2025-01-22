package br.com.yourhome.register.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClienteRepository extends JpaRepository<Cliente, String> {
}
