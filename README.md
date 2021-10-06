# CharactersRickAndMorty

## Objetivo do Projeto

Desenvolver um aplicativo com uma requisição simples (sem a necessidade de um KEY), para estudos dos conceitos básicos do desenvolvimento Android.

## Tecnologias utilizadas

- Projeto Desenvolvido em Kotlin
- Utilização da Arquitetura MVVM
- Utilização da RecyclerView
- Consumo de um API publica (sem a necessidade de KEY)
- Utilização do Retrofit
- Utilização do Data Binding
- Utilização do Live Data
- Biblioteca Picasso
- RX Java

## Descritivo do Projeto

#### 1 - Configurações iniciais do Projeto

#### 2 - Definindo o Layout
Para este projeto foi definido uma RecyclerView na Activy_Main.
Criado um novo item em Layout nomeado como list_item para idexar os objetos que serão apresentados na View, no caso, TextView para objetos Name, Species e Gender usando LinearLayout e uma ImageView para o objeto Image usando o ConstrainstLayout, todos dentro de um CardView.

#### 3 - Definindo o Retrofit e API
Utilizado o Retrofit obter as informações da página HTTP API para interface Kotlin. 
Dividindo em duas etapas:

3.1 Interface "CharactersApi"

Criado o arquivo de interface nomeado "CharactersApi", onde consta o endpoint "character", tendo ele como base para criar a função "getCharacters" com a resposta "Single<CharactersResponse>". 
```kotlin
  interface CharactersApi {

    @GET("character")
    fun getCharacters(): Single<CharactersResponse>

  }
```
3.2 Url Base "RetrofitService"
Definido a URL base para as requisições do "CharactersApi", no caso a URL base é "https://rickandmortyapi.com/api/".

const val BASE_URL = "https://rickandmortyapi.com/api/"

```kotlin
  class RetrofitService {
    companion object {
        val service: CharactersApi
        init {
            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            service = retrofit.create(CharactersApi::class.java)
        }
    }
}
```
3.3 Definindo as Classes
Como utilizado os dados de uma fonte externa torna-se necessário o uso de um leitor/conversor desses dados, utilizado um plugin kotlin serialization.
Para aplica-lo no projeto, na pasta "model" clicando com o botão direito no menu "New" na opção "Kotlin Data Class Code", na janela exibida clicando com o botão direito nas opções exibidas utilizo a "Retrive content from Http Url", na janela exibida insiro a URL base e clico em Ok voltando para a janela do "Kotlin Data Class" Code e defino o a "Class Name".
  
#### 4 - CharactersViewModel
 

#### 5 - Characters Adapter
Definido o nome da classe ViewModel como CharactersViewModel
#### 6 - Enable Networking

#### 7 - Arquitetura MVVM
Utilizando a arquitetura MVVM neste projeto
``

``
