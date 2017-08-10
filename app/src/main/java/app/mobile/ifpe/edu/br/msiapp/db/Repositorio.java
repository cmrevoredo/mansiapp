package app.mobile.ifpe.edu.br.msiapp.db;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.mobile.ifpe.edu.br.msiapp.Randomizador;
import app.mobile.ifpe.edu.br.msiapp.model.Alternativa;
import app.mobile.ifpe.edu.br.msiapp.model.Pergunta;

/**
 * Created by revor on 24/08/2016.
 */
public class Repositorio {

    private static Repositorio instance;
    private List<Pergunta> questionario;

    static{
        instance = new Repositorio();
    }

    private Repositorio(){
        this.gerar();
    }


    public static Repositorio getInstance(){
        return instance;
    }

    private void gerar(){
        String jsonString = "[{\"id\":1,\"problema\":\"Ao trocar a fonte e conectar o cabo de força na rede elétrica, o computador parou de funcionar.\",\"alternativas\":[{\"id\":1,\"descricao\":\"Fusível queimado\",\"valor\":10},{\"id\":2,\"descricao\":\"Resistor queimado\",\"valor\":0},{\"id\":3,\"descricao\":\"Ventoinha danificada\",\"valor\":-10},{\"id\":4,\"descricao\":\"Capacitor queimado\",\"valor\":0},{\"id\":5,\"descricao\":\"Sujeira na fonte\",\"valor\":-10}],\"dica\":\"Ao parar de funcionar, saiu um pouco de fumaça da fonte.\",\"sucesso\":\"Parabéns! É importante, antes de ligar qualquer equipamento eletrônico diretamente na energia,verificar a sua tensão, pois caso haja tensão diferente da indicada, o aparelho será danificado.\"},{\"id\":2,\"problema\":\"Todas as vezes que o computador é ligado, o usuário precisa atualizar a data e a hora.\",\"alternativas\":[{\"id\":6,\"descricao\":\"Fuso-horário desconfigurado\",\"valor\":0},{\"id\":7,\"descricao\":\"Bateria de lítio descarregada\",\"valor\":10},{\"id\":8,\"descricao\":\"Data e hora não configurada\",\"valor\":0},{\"id\":9,\"descricao\":\"BIOS desatualizada\",\"valor\":-10},{\"id\":10,\"descricao\":\"Memória RAM danificada\",\"valor\":-10}],\"dica\":\"O problema surgiu depois de muito tempo de uso do computador.\",\"sucesso\":\"Parabéns! Quando a bateria perde sua  autonomia, faz-se necessária sua troca para que os dados armazenados na CMOS não sejam perdidos.\"},{\"id\":3,\"problema\":\"Detecta-se que o dispositivo móvel conectado ao USB frontal não foi reconhecido.\",\"alternativas\":[{\"id\":11,\"descricao\":\"Dispositivo móvel queimado\",\"valor\":0},{\"id\":12,\"descricao\":\"Drivers de dispositivo móvel não instalado\",\"valor\":10},{\"id\":13,\"descricao\":\"Portas USB danificadas\",\"valor\":0},{\"id\":14,\"descricao\":\"Pinos de USB da placa mãe amassados\",\"valor\":-10},{\"id\":15,\"descricao\":\"Cabo do USB interno desconectado\",\"valor\":-10}],\"dica\":\"O S.O. apresenta no canto inferior da tela a seguinte mensagem: \\\"Dispositivo não Reconhecido\\\".\",\"sucesso\":\"Parabéns! Alguns dispositivos móveis necessitam de drivers específicos para o seu funcionamento.\"},{\"id\":4,\"problema\":\"Ao ligar o computador, nada aparece na tela.\",\"alternativas\":[{\"id\":16,\"descricao\":\"Memória Ram queimada\",\"valor\":10},{\"id\":17,\"descricao\":\"Barramentos danificados\",\"valor\":0},{\"id\":18,\"descricao\":\"Problema no speaker\",\"valor\":-10},{\"id\":19,\"descricao\":\"sujeira nos slots\",\"valor\":0},{\"id\":20,\"descricao\":\"Chip-set sul queimado\",\"valor\":-10}],\"dica\":\"Ao ser ligado, o computador emitiu dois bips longos.\",\"sucesso\":\"Parabéns! Após notar os bips, o usuário substituiu a memória RAM e o computador voltou a funcionar.\"},{\"id\":5,\"problema\":\"O computador ficou reiniciando após o cliente colocar uma nova placa de vídeo.\",\"alternativas\":[{\"id\":21,\"descricao\":\"Fonte de alimentação incompatível\",\"valor\":10},{\"id\":22,\"descricao\":\"Placa mãe danificada\",\"valor\":-10},{\"id\":23,\"descricao\":\"Cooler queimado\",\"valor\":-10},{\"id\":24,\"descricao\":\"PCI Express defeituoso\",\"valor\":0},{\"id\":25,\"descricao\":\"Processador incompatível\",\"valor\":0}],\"dica\":\"O computador funcionava normalmente antes da instalação do novo hardware.\",\"sucesso\":\"Parabéns! Algumas placas de vídeo consomem mais potência, portanto ao inserir uma nova placa de vídeo é necessário colocar uma fonte de alimentação com uma potência maior.\"},{\"id\":6,\"problema\":\"Ao tentar acessar a internet, o usuário notou que não havia conexão.\",\"alternativas\":[{\"id\":26,\"descricao\":\"Placa de rede onboard queimada\",\"valor\":10},{\"id\":27,\"descricao\":\"IP de rede desconfigurado\",\"valor\":-10},{\"id\":28,\"descricao\":\"Conector RJ-45 mal conectado\",\"valor\":0},{\"id\":29,\"descricao\":\"Roteador desligado\",\"valor\":0},{\"id\":30,\"descricao\":\"Provedor de internet indisponível\",\"valor\":-10}],\"dica\":\"O usuário percebeu no canto inferior da tela um \\\"X\\\" vermelho no ícone de rede. Todavia, notou também que o cabo de rede estava conectado normalmente.\",\"sucesso\":\"Parabéns! A presença do \\\"X\\\" no ícone de rede indica que o problema está diretamente ligado à placa de rede, logo, ao substituir a onboard pela offboard foi restabelecida.\"},{\"id\":7,\"problema\":\"O usuário adquiriu uma nova impressora, mas não conseguiu imprimir documento algum.\",\"alternativas\":[{\"id\":31,\"descricao\":\"Driver da impressora não instalado\",\"valor\":10},{\"id\":32,\"descricao\":\"Impressora sem tinta\",\"valor\":0},{\"id\":33,\"descricao\":\"Cabo USB da impressora danificado\",\"valor\":0},{\"id\":34,\"descricao\":\"Impressora queimada\",\"valor\":-10},{\"id\":35,\"descricao\":\"S.O. corrompido\",\"valor\":-10}],\"dica\":\"A impressora foi ligada e os cabos estavam conectados normalmente, mas não era apresentada informação específica da impressora no monitor.\",\"sucesso\":\"Parabéns! Para o correto funcionamento da impressora, é necessária a instalação do seu driver.\"},{\"id\":8,\"problema\":\"Um cliente adquiriu um processador novo para seu computador, mas não obteve êxito ao tentar instalá-lo.\",\"alternativas\":[{\"id\":36,\"descricao\":\"Processador incompatível com placa mãe\",\"valor\":10},{\"id\":37,\"descricao\":\"Pinos amassados\",\"valor\":0},{\"id\":38,\"descricao\":\"Socket de processador queimado\",\"valor\":0},{\"id\":39,\"descricao\":\"CPU_FAN desconectado\",\"valor\":-10},{\"id\":40,\"descricao\":\"Processador sem pasta térmica\",\"valor\":-10}],\"dica\":\"O processador não encaixa no socket da placa mãe.\",\"sucesso\":\"Parabéns! Ao adquirir um novo processador deve-se verificar a sua compatibilidade com a placa mãe.\"},{\"id\":9,\"problema\":\"O S.O. não reconhece toda a capacidade da memória Ram.\",\"alternativas\":[{\"id\":41,\"descricao\":\"Slots sujos\",\"valor\":0},{\"id\":42,\"descricao\":\"Problema em um dos pentes de memória\",\"valor\":-10},{\"id\":43,\"descricao\":\"Utilização de um S.O. com 32bits\",\"valor\":10},{\"id\":44,\"descricao\":\"Problema no chipset sul\",\"valor\":-10},{\"id\":45,\"descricao\":\"Processador incompatível\",\"valor\":0}],\"dica\":\"Os slots e os pentes de memória não estão queimados. Mas, ao colocar dois pentes de memória de 4GB cada, não foram reconhecidos, percebendo-se que só funcionam individualmente.\",\"sucesso\":\"Parabéns! A partir de 4GB, para reconhecer a capacidade total da memória RAM é necessário a utilização de um S.O. 64 bits, bem como, analisar a compatibilidade do processador com o S.O.\"},{\"id\":10,\"problema\":\"A página inicial do navegador foi substituída por outra página que o usuário não consegue removê-la.\",\"alternativas\":[{\"id\":46,\"descricao\":\"Instalação malsucedida do navegador\",\"valor\":0},{\"id\":47,\"descricao\":\"Histórico de navegação com vírus\",\"valor\":-10},{\"id\":48,\"descricao\":\"Falha na conexão\",\"valor\":-10},{\"id\":49,\"descricao\":\"Extensões e plug-ins instalados no navegador\",\"valor\":10},{\"id\":50,\"descricao\":\"Configurações básicas do navegador incorretas\",\"valor\":0}],\"dica\":\"Muitas vezes, clicar em determinados locais pode facilitar a entrada de malwares que causam problemas de configuração no navegador, como o aparecimento de propagandas indesejadas. Há também outros problemas que podem surgir.\",\"sucesso\":\"Parabéns! Alguns malwares podem danificar seu navegador, para evitar isso, além de manter seu antivírus atualizado, é indicado evitar a instalação de extensões e plug-ins suspeitos no navegador.\"},{\"id\":11,\"problema\":\"Aparece uma mensagem de falha no disco rígido ao ligar o computador.\",\"alternativas\":[{\"id\":51,\"descricao\":\"HD danificado\",\"valor\":10},{\"id\":52,\"descricao\":\"S.O. com falha\",\"valor\":0},{\"id\":53,\"descricao\":\"SETUP com problemas de inicialização\",\"valor\":-10},{\"id\":54,\"descricao\":\"Cabo do HD mal conectado\",\"valor\":0},{\"id\":55,\"descricao\":\"Vírus\",\"valor\":-10}],\"dica\":\"Ao tentar realizar o BOOT, o computador exibe no prompt a seguinte mensagem: \\\"A Disk read error occurred. Press Ctrl+Alt+Del to Restart\\\".\",\"sucesso\":\"Parabéns! Nesses casos, é aconselhável verificar se os cabos do HD estão todos conectados, caso estejam, faça a troca do HD.\"},{\"id\":12,\"problema\":\"O computador liga e inicia o S.O., porém o gabinete fica passando corrente elétrica ao toque do usuário.\",\"alternativas\":[{\"id\":56,\"descricao\":\"Chave da fonte desligada\",\"valor\":-10},{\"id\":57,\"descricao\":\"Falta de aterramento\",\"valor\":10},{\"id\":58,\"descricao\":\"Gabinete úmido\",\"valor\":0},{\"id\":59,\"descricao\":\"Fios desgastados\",\"valor\":0},{\"id\":60,\"descricao\":\"Reinstalar o S.O.\",\"valor\":-10}],\"dica\":\"Verificar se o cabo de força (a tomada) está ligado corretamente na rede elétrica.\",\"sucesso\":\"Parabéns! Para segurança tanto da máquina como do usuário é aconselhável o aterramento do equipamento.\"},{\"id\":13,\"problema\":\"Após algumas quedas de energia seguidas, a placa-mãe parou de reconhecer o processador.\",\"alternativas\":[{\"id\":61,\"descricao\":\"Pasta térmica ressecada\",\"valor\":0},{\"id\":62,\"descricao\":\"Processador queimado\",\"valor\":10},{\"id\":63,\"descricao\":\"Barramentos queimados\",\"valor\":0},{\"id\":64,\"descricao\":\"Pinos do socket amassados\",\"valor\":-10},{\"id\":65,\"descricao\":\"Problema de memória\",\"valor\":-10}],\"dica\":\"Quedas de energia ou alterações abruptas na tensão podem danificar alguns componentes do computador.\",\"sucesso\":\"Parabéns! O processador foi danificado devido às seguidas quedas de energia.\"},{\"id\":14,\"problema\":\"Ao reproduzir um vídeo, não foi possível ouvir o áudio.\",\"alternativas\":[{\"id\":66,\"descricao\":\"Alto falantes danificados\",\"valor\":10},{\"id\":67,\"descricao\":\"Driver de áudio não instalado\",\"valor\":0},{\"id\":68,\"descricao\":\"Software de reprodução sem plug-in de áudio\",\"valor\":0},{\"id\":69,\"descricao\":\"Placa de som queimada\",\"valor\":-10},{\"id\":70,\"descricao\":\"Arquivo de vídeo corrompido\",\"valor\":-10}],\"dica\":\"Os volumes do sistema e do software de mídia não estão baixos, nem estão em mute. Além disso, foi verificado que o plug da caixa de som está corretamente conectado.\",\"sucesso\":\"Parabéns! Nesse caso, poderia também ser a falta do driver de áudio, todavia não apareceria a opção de volume no canto inferior direito da tela.\"},{\"id\":15,\"problema\":\"O usuário não consegue conectar o notebook ao wi-fi.\",\"alternativas\":[{\"id\":71,\"descricao\":\"Senha de acesso inválida\",\"valor\":0},{\"id\":72,\"descricao\":\"Configuração do roteador em modo invisível\",\"valor\":10},{\"id\":73,\"descricao\":\"Drivers de rede não instalado\",\"valor\":-10},{\"id\":74,\"descricao\":\"Cabo de rede desconectado\",\"valor\":-10},{\"id\":75,\"descricao\":\"Roteador danificado\",\"valor\":0}],\"dica\":\"O roteador está ligado, mas as outras máquinas e dispositivos também não estão conseguindo encontrar o ID da rede wi-fi.\",\"sucesso\":\"Parabéns! Não basta ter a senha da rede para se conectar, é necessário que o roteador mantenha o SSID em broadcast, para que o mesmo possa ser encontrado automaticamente pelos dispositivos na rede.\"}]";
        questionario = new ArrayList<Pergunta>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject json = new JSONObject(jsonArray.getString(i));
                Pergunta p = new Pergunta();
                p.setDica(json.getString("dica"));
                p.setProblema(json.getString("problema"));
                p.setId(json.getInt("id"));
                p.setSucesso(json.getString("sucesso"));
                p.setAlternativas(new ArrayList<Alternativa>());
                JSONArray jsonA = new JSONArray(json.getString("alternativas"));
                for (int n=0;n<jsonA.length();n++){
                    JSONObject json2 = new JSONObject(jsonA.getString(n));
                    Alternativa a = new Alternativa();
                    a.setId(json2.getInt("id"));
                    a.setDescricao(json2.getString("descricao"));
                    a.setValor(json2.getInt("valor"));
                    p.getAlternativas().add(a);
                }
                questionario.add(p);
            }
            List<Pergunta> embaralhado = new ArrayList<Pergunta>();
            List<Integer> sorteio = Randomizador.gerarAleatorio(15);
            for(Integer i : sorteio){
                embaralhado.add(questionario.get(i));
            }
            questionario = embaralhado;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<Pergunta> getQuestionario() {
        return questionario;
    }

    public Pergunta getPergunta(int indice) {
        return questionario.get(indice);
    }
}

