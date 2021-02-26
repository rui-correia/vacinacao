package br.com.braz.rui.write.application.service

import br.com.braz.rui.BuscarPacienteRequest
import br.com.braz.rui.write.adapter.out.PacienteRepository
import br.com.braz.rui.write.application.domain.Paciente
import javax.inject.Singleton


@Singleton
class BuscarPacienteHandler(private val repository: PacienteRepository) {

    fun buscarPaciente(request: BuscarPacienteRequest): Paciente {
        return repository.findById(request.id).orElseThrow {
            Exception("Usuário com email inserido não foi encontrado")
        }
    }
}