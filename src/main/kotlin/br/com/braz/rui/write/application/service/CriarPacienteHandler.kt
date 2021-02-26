package br.com.braz.rui.write.application.service

import br.com.braz.rui.write.adapter.out.PacienteRepository
import br.com.braz.rui.write.application.domain.Paciente
import javax.inject.Singleton

@Singleton
class CriarPacienteHandler(private val repository: PacienteRepository) {

    fun criarPacienteHandle(command: CriarPacienteCommand) {
        repository.save(
            Paciente(
                nome = command.nome,
                email = command.email,
                cpf = command.cpf,
                dataNascimento = command.dataNascimento
            )
        )
    }

}