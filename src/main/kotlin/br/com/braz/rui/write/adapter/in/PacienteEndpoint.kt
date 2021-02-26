package br.com.braz.rui.write.adapter.`in`

import br.com.braz.rui.*
import br.com.braz.rui.write.application.service.BuscarPacienteHandler
import br.com.braz.rui.write.application.service.CriarPacienteCommand
import br.com.braz.rui.write.application.service.CriarPacienteHandler
import com.google.protobuf.Empty
import javax.inject.Singleton

@Singleton
class PacienteEndpoint(
    private val criarPacienteHandler: CriarPacienteHandler,
    private val buscarPacienteHandler: BuscarPacienteHandler
) : PacienteServiceGrpcKt.PacienteServiceCoroutineImplBase() {
    override suspend fun criarPaciente(request: PacienteRequest): Empty {

        val command = CriarPacienteCommand(
            request.nome,
            request.email,
            request.cpf,
            request.dataNascimento
        )
        criarPacienteHandler.criarPacienteHandle(command)

        return Empty.newBuilder().build()
    }

    override suspend fun buscarPaciente(request: BuscarPacienteRequest): PacienteResponse {

        return buscarPacienteHandler.buscarPaciente(request).toResponse()
    }

}
