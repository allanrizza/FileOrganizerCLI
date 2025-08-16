# File Organizer CLI em Kotlin 📂

Este é um projeto simples, criado com o objetivo de praticar conceitos básicos da linguagem **Kotlin**, incluindo:

* Manipulação de arquivos e diretórios com a API `java.nio`.
* Criação de uma aplicação de linha de comando (CLI).
* Uso de bibliotecas externas (`kotlinx-cli`).
* Configuração de um projeto com Gradle.
* Property Delegate

O código é funcional, mas não foi projetado para ser uma ferramenta de produção robusta.

---

## O que o projeto faz?

É uma ferramenta de linha de comando que organiza os arquivos de uma pasta específica, movendo-os para subpastas nomeadas de acordo com suas extensões.

Por exemplo, um arquivo `relatorio.pdf` será movido para uma subpasta chamada `pdf/`, e uma `foto.jpg` para uma subpasta `jpg/`. Arquivos sem extensão são movidos para uma pasta `outros/`.

---

## Tecnologias Utilizadas

* **Linguagem**: [Kotlin](https://kotlinlang.org/)
* **Sistema de Build**: [Gradle](https://gradle.org/)
* **Biblioteca CLI**: [kotlinx-cli](https://github.com/Kotlin/kotlinx-cli)
* **Ambiente de Execução**: JVM (requer um JDK instalado)

---

## Como Usar

### 1. Pré-requisitos

* Você precisa ter um **JDK (Java Development Kit)**, versão 11 ou superior, instalado em sua máquina.

### 2. Compilando o Projeto

Para criar o arquivo `.jar` executável, navegue até a pasta raiz do projeto no seu terminal e execute o comando do Gradle Wrapper:

```bash
# Para Linux/macOS
./gradlew shadowJar

# Para Windows
gradlew.bat shadowJar
```
Este comando irá compilar o código e empacotar a aplicação em um único arquivo localizado em ```build/libs/file-organizer-1.0.jar```.

### 3. Executando a Ferramenta

Para organizar uma pasta, execute o comando abaixo, substituindo ```/caminho/para/sua/pasta``` pelo caminho real da pasta que você deseja organizar:
```bash
java -jar build/libs/file-organizer-1.0.jar /caminho/para/sua/pasta
```

#### Exemplo Prático:
```bash
# Comando para organizar a pasta "Downloads" do usuário "allan"
java -jar build/libs/file-organizer-1.0.jar /home/allan/Downloads
```
A ferramenta irá exibir no terminal os arquivos que estão sendo movidos e as pastas que estão sendo criadas.