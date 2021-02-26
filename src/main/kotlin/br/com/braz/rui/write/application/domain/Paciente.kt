package br.com.braz.rui.write.application.domain

import br.com.braz.rui.PacienteResponse
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Paciente(

    @Id
    @GeneratedValue
    var id: Long? = null,
    @field:NotBlank(message = "Nome não pode ficar em branco.")
    var nome: String,
    @field:Email(message = "Formato de email inválido.")
    @field:NotBlank(message = "Email não pode ficar em branco.")
    var email: String,
    @field:NotBlank
    var cpf: String,
    @field:NotNull
    var dataNascimento: String
) {
    fun toResponse(): PacienteResponse {
        return PacienteResponse.newBuilder()
            .setNome(this.email)
            .setEmail(this.email)
            .build()
    }
}


