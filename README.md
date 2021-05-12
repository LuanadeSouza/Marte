# Fotos Marcianas 
Neste aplicativo estou conectado a um serviço da web para recuperar e exibir as fotos de Marte. 
As imagens são fotos da vida real de Marte.
Nele uso uma camada para o serviço de rede que se comunica com o servidor de back-end e busca os dados necessários, 
utilizando uma biblioteca de terceiros para implementar isso, chamada Retrofit. 

Solicitação de serviço Web 
- GET para recuperar dados do servidor 
- POST ou PUT para adicionar / criar / atualizar o servidor com novos dados 
- DELETE para deletar dados do servidor

O ViewModel se comunica diretamente com essa camada de rede e é responsável por fazer a chamada de red
e para obter os dados das fotos de Marte usando LiveData com vinculação de dados para atualizar a IU do aplicativo quando os dados forem atualizados.

 <img width="200" src="https://user-images.githubusercontent.com/49947803/118002881-6f24b700-b31e-11eb-953a-cd4c852fe09e.png">

