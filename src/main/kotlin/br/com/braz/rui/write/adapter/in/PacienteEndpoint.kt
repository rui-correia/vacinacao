package br.com.braz.rui.write.adapter.`in`

import br.com.braz.rui.PacienteRequest
import br.com.braz.rui.PacienteServiceGrpcKt
import br.com.braz.rui.write.application.service.CriarPacienteCommand
import br.com.braz.rui.write.application.service.CriarPacienteHandler
import com.google.protobuf.Empty
import javax.inject.Singleton

@Singleton
class PacienteEndpoint(
    private val handler: CriarPacienteHandler
) : PacienteServiceGrpcKt.PacienteServiceCoroutineImplBase() {
    override suspend fun criarPaciente(request: PacienteRequest): Empty {

        val command = CriarPacienteCommand(
            request.nome,
            request.email,
            request.cpf,
            request.dataNascimento
        )
        handler.handle(command)

        return Empty.newBuilder().build()
    }
}
