package org.example

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.system.exitProcess

    fun main(args: Array<String>) {
        val parser = ArgParser("FileOrganizerCLI")
        val sourcePath by parser.argument(
            type = ArgType.String,
            fullName = "source-directory",
            description = "Caminho para a pasta que será organizada"
        )

        parser.parse(args)

        val directoryPath: Path = Paths.get(sourcePath)

        if(!Files.exists(directoryPath)) {
            println("Erro: o diretório '$sourcePath' não existe.")
            exitProcess(1)
        }

        if(!Files.isDirectory(directoryPath)) {
            println("Erro: o caminho '$sourcePath' não é um diretório.")
            exitProcess(1)
        }

        println("Organizando arquivos em: $directoryPath")

        try {
            Files.list(directoryPath).forEach { filePath ->
                if(Files.isRegularFile(filePath)) {
                    val extension = filePath.fileName.toString().substringAfterLast('.', "outros")
                    val targetDir = directoryPath.resolve(extension)

                    if(!Files.exists(targetDir)) {
                        println("Criando pasta: $targetDir")
                        Files.createDirectory(targetDir)
                    }

                    val destinationPath = targetDir.resolve(filePath.fileName)
                    println("Movendo '${filePath.fileName}' para '$extension/'")
                    Files.move(filePath, destinationPath)
                }
            }
        } catch(e: Exception) {
            println("Ocorreu um erro durante a organização: ${e.message}")
            exitProcess(1)
        }

        println("\nOrganização concluída com sucesso!")
    }