package br.com.braz.rui.write.application.service

data class CriarPacienteCommand(
    val nome: String,
    val email: String,
    val cpf: String,
    val dataNascimento: String
)