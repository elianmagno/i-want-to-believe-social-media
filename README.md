# 📱 I Want To Believe - Rede Social para Android

Uma pequena rede social para Android onde pode partilhar os seus momentos.  
Crie um perfil, publique fotos com descrições e veja o feed de outros utilizadores.  
Desenvolvido com **Kotlin, Jetpack Compose, Hilt e Firebase** como um estudo de arquitetura moderna Android.

---

## ✨ Funcionalidades

- **Autenticação de Utilizador**: Sistema completo de registo e login com e-mail e palavra-passe.  
- **Feed Cronológico**: Visualize as publicações de todos os utilizadores em tempo real.  
- **Criação de Posts**: Publique as suas próprias fotos com uma descrição.  
- **Perfis de Utilizador**: Visualize e edite as suas informações, como nome, e-mail e foto de perfil.  
- **Interface Moderna**: UI totalmente construída com Jetpack Compose, seguindo os princípios de Material Design.  

---

## 🛠️ Tecnologias e Arquitetura

Este projeto foi construído com foco em tecnologias e padrões modernos do ecossistema Android.

- **Linguagem**: 100% Kotlin  
- **UI**: Jetpack Compose  
- **Arquitetura**: MVVM (Model-View-ViewModel)  
- **Injeção de Dependência**: Hilt  
- **Backend**: Firebase  
- **Autenticação**: Firebase Authentication  
- **Base de Dados**: Cloud Firestore  
- **Armazenamento**: Cloud Storage para imagens  
- **Carregamento de Imagens**: Coil  

---

## 🚀 Como Executar o Projeto

Para compilar e executar este projeto, siga os passos de configuração do Firebase:

1. **Crie um Projeto Firebase**  
   Se ainda não tiver um, crie um novo projeto na consola do Firebase.  

2. **Configure a sua Aplicação Android**  
   Adicione uma aplicação Android ao seu projeto Firebase.  
   O **nome do pacote (package name)** para esta aplicação é:  
   ```
   com.elian.iwanttobelieve
   ```

   📺 Guia útil: [Como adicionar o Firebase a um projeto Android (Guia Visual)](https://firebase.google.com/docs/android/setup)

3. **Adicione o Ficheiro de Configuração**  
   - Após configurar a aplicação no Firebase, irá receber um ficheiro `google-services.json`.  
   - Faça o download deste ficheiro.  
   - Copie e cole o ficheiro dentro da pasta `app/` do seu projeto.  

4. **Configure as Regras de Segurança**  
   - No painel do Firebase, configure as regras de **Firestore** e **Storage**  
   - Permita leitura e escrita apenas para **utilizadores autenticados**.  

5. **Compile e Execute**  
   - Com o ficheiro de configuração no lugar certo, o Android Studio deverá conseguir compilar e executar a aplicação sem problemas.  

---

## 🖼️ Galeria

### 🔐 Tela de Login
<img width="250" alt="sign in" src="https://github.com/user-attachments/assets/411a793f-1237-4d9c-9750-556d77da7f69" />

### 📝 Tela de Cadastro
<img width="250" alt="sign up" src="https://github.com/user-attachments/assets/1133a743-47e4-4f9b-b8cd-78d2bfa5edd2" />

### 📰 Feed Principal
<img width="250" alt="feed" src="https://github.com/user-attachments/assets/7f59a1c5-7730-4cd1-b32b-dceb70386870" />

### 👤 Perfil do Usuário
<img width="250" alt="profile" src="https://github.com/user-attachments/assets/6ddf7393-9a32-4978-8e82-29fea0b5024d" />

### ✏️ Editar Perfil
<img width="250" alt="update" src="https://github.com/user-attachments/assets/23b4cdf8-da72-4b58-a818-a3772b26b906" />

### ➕ Criar Publicação
<img width="250" alt="post" src="https://github.com/user-attachments/assets/33e2cb11-4e60-4741-92f9-46304603278e" />

---

📌 Projeto desenvolvido como estudo de **Arquitetura Moderna Android**.
