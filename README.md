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

Na ultima atualização do aplicativo, é possivel ver o tipo de propriedade (alugar e comprar), no menu de opções do aplicativo você pode filtrar a grade para mostrar apenas as propriedades que estão para alugar ou vender e ao clicar na propriedade você tem detalhes da propriedade individual

<img width="200" src="https://user-images.githubusercontent.com/49947803/135144858-f59f4b3a-00d8-47de-8af8-880df03f06c1.jpeg"> <img width="200" src="https://user-images.githubusercontent.com/49947803/135144525-10c75427-7cc7-4b9a-9b4b-acbc283bc095.jpeg">
<img width="200" src="https://user-images.githubusercontent.com/49947803/135144521-1d0ef4e6-814c-480e-815e-ae2106c1fd48.jpeg">
<img width="200" src="https://user-images.githubusercontent.com/49947803/135144864-63c82cd1-28c2-441e-880d-ccb66d007b92.jpeg">
<img width="200" src="https://user-images.githubusercontent.com/49947803/135144869-2e9d25e5-e980-4e35-97e9-16d53a50acb7.jpeg">
