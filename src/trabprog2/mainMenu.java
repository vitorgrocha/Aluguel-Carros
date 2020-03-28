package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList; //Library para Lista

public class mainMenu {

    public void print_main_menu() throws FileNotFoundException, UnsupportedEncodingException {
        //Clientes
        listaClientes listaC = null;
        clientes cliente = null;        
        loadFile f = new loadFile(); //Instanciando loadFile()

        //Carros
        carros carro = null;
        listaCarros listCar = null;       
        loadFileCar fC = new loadFileCar();

        //Relatorios
        relatorios outRelatorio = null;
        listaRelatorios outRelatorioLista = null;
        loadFileRelatorio fR = new loadFileRelatorio();
        LocalDate dataR = null;

        //Alugueis
        alugueis aluguel = null;
        listaAlugueis listaAlug = null;
        loadFileAluguel fA = new loadFileAluguel();

        //Scanner
        Scanner sc = new Scanner(System.in);

        if (f.checkFile()) { //Cliente check
            int fileIteration = 0;
            ArrayList<String> listaFromFile = new ArrayList<>();
            int fCount = f.getCountFile();  //Quantidade de pessoas que foram cadastradas
            listaClientes.setCount(fCount); //Seta Count para a quantidade de pessoas cadastradas, File
            listaFromFile = f.getListaFile();  //Pegando da lista que veio do arquivo e preenchendo a estrutura clientes                      
            while (fCount > 0) {
                cliente = new clientes(listaFromFile.get(fileIteration), Integer.parseInt(listaFromFile.get(fileIteration + 1)), listaFromFile.get(fileIteration + 2),
                        Integer.parseInt(listaFromFile.get(fileIteration + 3)), Float.parseFloat(listaFromFile.get(fileIteration + 4)));               //Instanciando cliente
                listaC = new listaClientes(cliente, true);                                          //Pegando objeto cliente e colocando em uma lista, true pois está vindo de arquivo 
                fileIteration = fileIteration + 5;                                                  // 5 == quantidade de informação (Nome, cpf, rua, telefone)
                fCount--;                                                                           //
            }
        }
        /**
         * ********************************************************************
         */
        if (fC.checkFile()) { //Carros check
            int fileIterationC = 0;
            ArrayList<String> listaFromFileC = new ArrayList<>();
            int fCountC = fC.getCountFile();  //Quantidade de carros que foram cadastrados            
            listaCarros.setCount(fCountC);  //Seta Count para a quantidade de carros cadastrados, File
            listaFromFileC = fC.getListaFile();  //Pegando da lista que veio do arquivo e preenchendo a estrutura carros            
            while (fCountC > 0) {
                carro = new carros(listaFromFileC.get(fileIterationC), listaFromFileC.get(fileIterationC + 1), Integer.parseInt(listaFromFileC.get(fileIterationC + 2)),
                        Integer.parseInt(listaFromFileC.get(fileIterationC + 3)), Float.parseFloat(listaFromFileC.get(fileIterationC + 4)),
                        Float.parseFloat(listaFromFileC.get(fileIterationC + 5)), listaFromFileC.get(fileIterationC + 6));                //Instanciando carro
                listCar = new listaCarros(carro, true);                                          //Pegando objeto carro e colocando em uma lista, true pois está vindo de arquivo 
                fileIterationC = fileIterationC + 7;                                            // 7 == quantidade de informação (Placa, descricao, etc...)               
                fCountC--;
            }
        }
        /**
         * ********************************************************************
         */
        if (fR.checkFile()) { //Relatorios check
            int fileIterationR = 0;
            ArrayList<String> listaFromFileR = new ArrayList<>();
            int fCountR = fR.getCountFile();       //Quantidade de relatorios que foram gerados            
            outRelatorioLista.setCount(fCountR);  //Seta Count para a quantidade de relatorios gerados, File
            listaFromFileR = fR.getListaFile();  //Pegando da lista que veio do arquivo e preenchendo a estrutura relatorios            
            while (fCountR > 0) {
                outRelatorio = new relatorios(listaFromFileR.get(fileIterationR), Integer.parseInt(listaFromFileR.get(fileIterationR + 1)), LocalDate.parse(listaFromFileR.get(fileIterationR + 2)),
                        Boolean.parseBoolean(listaFromFileR.get(fileIterationR + 3)));                 //Instanciando relatorio
                outRelatorioLista = new listaRelatorios(outRelatorio, true);                          //Pegando objeto relatorio e colocando em uma lista, true pois está vindo de arquivo 
                fileIterationR = fileIterationR + 4;                                                 // 4 == quantidade de informação               
                fCountR--;
            }
        }
        if (fA.checkFile()) { //Alugueis check
            int fileIterationA = 0;
            ArrayList<String> listaFromFileA = new ArrayList<>();
            int fCountA = fA.getCountFile();       //Quantidade de alugueis que foram gerados            
            listaAlug.setCount(fCountA);          //Seta Count para a quantidade de alugueis gerados, File
            listaFromFileA = fA.getListaFile();  //Pegando da lista que veio do arquivo e preenchendo a estrutura alugueis            
            while (fCountA > 0) {               //Repete enquanto o contador for > 0
                aluguel = new alugueis(listaFromFileA.get(fileIterationA), Integer.parseInt(listaFromFileA.get(fileIterationA + 1)),
                        LocalDate.parse(listaFromFileA.get(fileIterationA + 2)), Integer.parseInt(listaFromFileA.get(fileIterationA + 3)));   //Instanciando aluguel
                listaAlug = new listaAlugueis(aluguel, true);                          //Pegando objeto aluguel e colocando em uma lista, true pois está vindo de arquivo 
                fileIterationA = fileIterationA + 4;                                  // 4 == quantidade de informação               
                fCountA--;
            }
        }

        //Menu
        boolean quit = false;   //Sair da aplicação                       
        System.out.println("1 - Cadastrar Cliente\n2 - Cadastrar Carro\n3 - Aluguel\n4 - Devolver carro\n5 - Relatorios\n6 - Pagar dívida!\n0 - Sair\n");
        do {
            int menuOp = sc.nextInt();
            sc.nextLine(); //Scanner workaround
            switch (menuOp) {
                case 1: //Clientes
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Cpf: ");
                    int cpf = sc.nextInt();
                    sc.nextLine(); //Scanner workaround
                    System.out.println("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.println("Telefone: ");
                    int telefone = sc.nextInt();
                    cliente = new clientes(nome, cpf, endereco, telefone, 0.00f); //Instanciando cliente
                    listaC = new listaClientes(cliente, false); //Pegando objeto cliente e colocando em uma lista                     
                    break;
                case 2: //Carros
                    System.out.println("Placa: ");
                    String placa = sc.nextLine();
                    System.out.println("Descrição: ");
                    String descricao = sc.nextLine();
                    System.out.println("Situação: ");
                    int situacao = sc.nextInt();
                    sc.nextLine(); //Scanner workaround
                    System.out.println("Km rodados: ");
                    int km = sc.nextInt();
                    sc.nextLine(); //Scanner workaround
                    System.out.println("Preço por KM: ");
                    float precoKm = sc.nextFloat();
                    sc.nextLine(); //Scanner workaround
                    System.out.println("Taxa diária : ");
                    float taxaDiaria = sc.nextFloat();
                    sc.nextLine(); //Scanner workaround
                    System.out.println("Observação : ");
                    String observacao = sc.nextLine();
                    carro = new carros(placa, descricao, situacao, km, precoKm, taxaDiaria, observacao); //Instanciando carro
                    listCar = new listaCarros(carro, false); //Pegando objeto carro e colocando em uma lista                     
                    break;
                case 3:
                    String carroEs = null;
                    int clientEs = 0;
                    int sizeTeste = 0;
                    try {
                        for (int i = 0; i < listCar.getListaC().size(); i++) { //Mostra todos os carros
                            if (listCar.getListaC().get(i).getSitiacao() == 1) {
                                System.out.println("Carro: " + (i + 1));
                                System.out.println("Placa>            " + listCar.getListaC().get(i).getPlaca());
                                System.out.println("Descrição>        " + listCar.getListaC().get(i).getDescricao());
                                System.out.println("Quilômetros>      " + listCar.getListaC().get(i).getKm());
                                System.out.println("Preço por KM>   R$" + listCar.getListaC().get(i).getPrecoKm());
                                System.out.println("Preço diária>   R$" + listCar.getListaC().get(i).getTaxaDiaria());
                                System.out.println("Observações>      " + listCar.getListaC().get(i).getObservacao());
                                System.out.println("");
                            } else if (listCar.getListaC().get(i).getSitiacao() == 0) {
                                System.out.println("Carro: " + (i + 1) + " (CARRO INDISPONÍVEL)");
                                System.out.println("Placa>            " + listCar.getListaC().get(i).getPlaca());
                                System.out.println("Descrição>        " + listCar.getListaC().get(i).getDescricao());
                                System.out.println("Quilômetros>      " + listCar.getListaC().get(i).getKm());
                                System.out.println("Preço por KM>   R$" + listCar.getListaC().get(i).getPrecoKm());
                                System.out.println("Preço diária>   R$" + listCar.getListaC().get(i).getTaxaDiaria());
                                System.out.println("Observações>      " + listCar.getListaC().get(i).getObservacao());
                                sizeTeste++;
                                System.out.println("");
                            } else {
                                System.out.println("Não existe carros disponíveis!");
                                break;
                            }
                        }
                        if (!(listCar.getListaC().size() == sizeTeste)) { //Se existe carros disponíveis
                            System.out.println("Selecionar carro pela placa: ");
                            carroEs = sc.nextLine(); //Placa                        
                            System.out.println("");
                        } else {
                            System.out.println("Não existe carros disponíveis!");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Sem carros!");
                        break;
                    }
                    try {
                        sizeTeste = 0;
                        for (int i = 0; i < listaC.getListaClientes().size(); i++) {
                            if (listaC.getListaClientes().get(i).getDividaCliente() > 0.00f) {
                                System.out.println("Cliente> " + (i + 1) + " [" + listaC.getListaClientes().get(i).getNomeCliente() + "]" + "\ncom dívida pendente! Não é possível alugar!");
                                System.out.println("");
                                sizeTeste++;
                            } else {
                                System.out.println("Cliente: " + (i + 1));
                                System.out.println("Nome>     " + listaC.getListaClientes().get(i).getNomeCliente());
                                System.out.println("Cpf>      " + listaC.getListaClientes().get(i).getCpf());
                                System.out.println("");
                            }
                        }
                        if (!(listaC.getListaClientes().size() == sizeTeste)) { //Se existe clientes disponíveis
                            System.out.println("Selecionar cliente pelo CPF: ");
                            clientEs = sc.nextInt();
                            sc.nextLine(); //Scanner workaround                      
                            System.out.println("");
                        } else {
                            System.out.println("Não existe clientes disponíveis!");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Sem clientes!");
                        break;
                    }
                    System.out.println("Tipo de aluguel: \n1 - Diária\n2 - Por Km");
                    int clienteOp = sc.nextInt();
                    sc.nextLine(); //Work around
                    aluguel = new alugueis(carroEs, clientEs, LocalDate.now(), clienteOp);
                    listaAlug = new listaAlugueis(aluguel, false);
                    //Relatorio
                    outRelatorio = new relatorios(carroEs, clientEs, LocalDate.now(), true);  //Instanciando relatorios                     
                    outRelatorioLista = new listaRelatorios(outRelatorio, false);
                    //Como carro foi alugado, reescreve o arquivo
                    try { //Selecionando carro pela placa                       
                        PrintWriter pR = new PrintWriter(new FileOutputStream(new File("carros.txt"), false));
                        for (int i = 0; i < listCar.getListaC().size(); i++) {
                            if (listCar.getListaC().get(i).getPlaca().equals(carroEs)) {
                                listCar.getListaC().get(i).setSitiacao(0);             //Carro se torna indisponível
                            }
                            try { //Rescrevendo no arquivo quando situação do carro se altera                                                
                                pR.println(listCar.getListaC().get(i).getPlaca());
                                pR.println(listCar.getListaC().get(i).getDescricao());
                                pR.println(listCar.getListaC().get(i).getSitiacao());
                                pR.println(listCar.getListaC().get(i).getKm());
                                pR.println(listCar.getListaC().get(i).getPrecoKm());
                                pR.println(listCar.getListaC().get(i).getTaxaDiaria());
                                pR.println(listCar.getListaC().get(i).getObservacao());
                            } catch (Exception e) {
                                System.out.println("Erro aluguel!");
                            }
                        }
                        pR.close(); //Fechar arquivo
                        System.out.println("");
                    } catch (Exception e) {
                        System.out.println("Erro! File!");
                        break;
                    }
                    break;
                case 4: //Devolução
                    String carroDev = null;
                    float carPagDia = 0.00f,
                     carPagkm = 0.00f;
                    int carCpf = 0,
                     carDisp = 0,
                     da = 0;
                    try {
                        for (int i = 0; i < listCar.getListaC().size(); i++) {
                            if (listCar.getListaC().get(i).getSitiacao() == 0) {
                                System.out.println("Carro: " + (i + 1));
                                System.out.println("Placa>            " + listCar.getListaC().get(i).getPlaca());
                                System.out.println("Descrição>        " + listCar.getListaC().get(i).getDescricao());
                                System.out.println("Quilômetros>      " + listCar.getListaC().get(i).getKm());
                                System.out.println("Preço por KM>   R$" + listCar.getListaC().get(i).getPrecoKm());
                                System.out.println("Preço diária>   R$" + listCar.getListaC().get(i).getTaxaDiaria());
                                System.out.println("Observações>      " + listCar.getListaC().get(i).getObservacao());
                                System.out.println("");
                            } else if (listCar.getListaC().get(i).getSitiacao() == 1) {
                                carDisp++;
                            } else {
                                System.out.println("Não existe carros disponíveis para devolução!");
                                break;
                            }
                        }
                        if (!(listCar.getListaC().size() == carDisp)) {
                            System.out.println("Selecionar carro pela placa: ");
                            carroDev = sc.nextLine(); //Placa                        
                            System.out.println("");
                        } else {
                            System.out.println("Não existe carros disponíveis para devolução!");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Sem carros!");
                        break;
                    }
                    try { //Selecionando carro pela placa                       
                        //Altero as informações e depois reescrevo o arquivo com as informações alteradas
                        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("carros.txt"), false));
                        for (int i = 0; i < listCar.getListaC().size(); i++) {
                            if (listCar.getListaC().get(i).getPlaca().equals(carroDev)) {
                                System.out.println("Quantos Km foram rodados: ");
                                da = sc.nextInt();
                                sc.nextLine(); //Workaround                                
                                carPagDia = listCar.getListaC().get(i).getTaxaDiaria();
                                carPagkm = listCar.getListaC().get(i).getPrecoKm();
                                listCar.getListaC().get(i).setSitiacao(1);
                                listCar.getListaC().get(i).setKm(listCar.getListaC().get(i).getKm() + da);
                                //listCar.getListaC().get(i).setClienteAluguel(0);
                            }
                            try { //Rescrevendo no arquivo quando situação do carro se altera                                                
                                wr.println(listCar.getListaC().get(i).getPlaca());
                                wr.println(listCar.getListaC().get(i).getDescricao());
                                wr.println(listCar.getListaC().get(i).getSitiacao());
                                wr.println(listCar.getListaC().get(i).getKm());
                                wr.println(listCar.getListaC().get(i).getPrecoKm());
                                wr.println(listCar.getListaC().get(i).getTaxaDiaria());
                                wr.println(listCar.getListaC().get(i).getObservacao());
                            } catch (Exception e) {
                                System.out.println("Erro! File!");
                            }
                        }
                        wr.close(); //Fechar arquivo
                        System.out.println("");
                    } catch (Exception e) {
                        System.out.println("Erro! Devolução File!");
                        break;
                    }
                    //Pergunta se o cliente pagou o aluguel que fez
                    System.out.println("Cliente pagou o aluguel? S | N");
                    String pag = sc.nextLine();
                    pag.toLowerCase();
                    if (pag.equals("n")) { //Cliente não pagou o aluguel
                        try {
                            for (int j = 0; j < listaAlug.getListaC().size(); j++) { //Loop lista de alugueis
                                if (listaAlug.getListaC().get(j).getAlugPlaca().equals(carroDev)) { //Para na placa informada
                                    for (int i = 0; i < listaC.getListaClientes().size(); i++) { //Loop lista clientes
                                        if (listaC.getListaClientes().get(i).getCpf() == listaAlug.getListaC().get(j).getAlugCpf()) { //Cpf
                                            System.out.println("Cliente: " + (i + 1));
                                            System.out.println("Nome>     " + listaC.getListaClientes().get(i).getNomeCliente());
                                            System.out.println("Cpf>      " + listaC.getListaClientes().get(i).getCpf());
                                            carCpf = listaC.getListaClientes().get(i).getCpf();
                                            if (listaAlug.getListaC().get(j).getOp() == 1) {
                                                System.out.println("Quantos dias o carro foi alugado: "); //Calcular dívida
                                                da = sc.nextInt();
                                                sc.nextLine();
                                                listaC.getListaClientes().get(i).setDividaCliente(carPagDia * da);      //Setando a divida  
                                                break;
                                            } else if (listaAlug.getListaC().get(j).getOp() == 2) {
                                                listaC.getListaClientes().get(i).setDividaCliente(carPagkm * da);      //Setando a divida 
                                                break;
                                            } else {
                                                System.out.println("Inválido!");
                                                break;
                                            }
                                        }
                                    }
                                    //Reescrevendo arquivos alugueis e countAlugueis
                                    PrintWriter wr = new PrintWriter(new FileOutputStream(new File("alugueis.txt"), false));
                                    listaAlug.getListaC().remove(j); //Removi o o aluguel da lista
                                    listaAlug.setCount(listaAlug.getCount() - 1); //Decremento o count
                                    for (int i = 0; i < listaAlug.getListaC().size(); i++) {
                                        try {
                                            wr.println(listaAlug.getListaC().get(i).getAlugPlaca());
                                            wr.println(listaAlug.getListaC().get(i).getAlugCpf());
                                            wr.println(listaAlug.getListaC().get(i).getAlugDate());
                                            wr.println(listaAlug.getListaC().get(i).getOp());
                                        } catch (Exception e) {
                                            System.out.println("Erro! File! Alug Pag");
                                        }
                                    }
                                    wr.close();
                                    wr = new PrintWriter(new FileOutputStream(new File("countAlugueis.txt"), false));
                                    wr.println(listaAlug.getCount());
                                    wr.close();
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO PAG ALUGUEL!");
                        }
                        try {
                            PrintWriter wr = new PrintWriter(new FileOutputStream(new File("clientes.txt"), false));
                            for (int i = 0; i < listaC.getListaClientes().size(); i++) {
                                try { //Rescrevendo no arquivo quando situação do carro se altera                                            
                                    wr.println(listaC.getListaClientes().get(i).getNomeCliente());
                                    wr.println(listaC.getListaClientes().get(i).getCpf());
                                    wr.println(listaC.getListaClientes().get(i).getEnderecoCliente());
                                    wr.println(listaC.getListaClientes().get(i).getTelefoneCliente());
                                    wr.println(listaC.getListaClientes().get(i).getDividaCliente());
                                } catch (Exception e) {
                                    System.out.println("Erro! File! Alug Pag");
                                }
                            }
                            wr.close();
                        } catch (Exception e) {
                            System.out.println("Erro! File!");
                        }
                    } else { //Pagou
                        //Reescrevendo arquivos alugueis e countAlugueis
                        PrintWriter wr = null;
                        for (int j = 0; j < listaAlug.getListaC().size(); j++) { //Loop lista alugueis
                            if (listaAlug.getListaC().get(j).getAlugPlaca().equals(carroDev)) {
                                for (int i = 0; i < listaC.getListaClientes().size(); i++) { //Loop lista clientes
                                    if (listaC.getListaClientes().get(i).getCpf() == listaAlug.getListaC().get(j).getAlugCpf()) {
                                        //Arquivo com nome do cliente + data do pagamento
                                        wr = new PrintWriter(new FileOutputStream(new File(listaC.getListaClientes().get(i).getNomeCliente() + "_" + LocalDate.now().toString() + "_pago_devolucao.txt"), false));
                                        wr.println("Devolução recebida!"); //"Recibo"   
                                        carCpf = listaAlug.getListaC().get(j).getAlugCpf();
                                        wr.close();
                                    }
                                }
                            }
                        }
                        //Reescrevendo countAlugueis                        
                        wr = new PrintWriter(new FileOutputStream(new File("countAlugueis.txt"), false));
                        for (int j = 0; j < listaAlug.getListaC().size(); j++) {
                            if (listaAlug.getListaC().get(j).getAlugPlaca().equals(carroDev)) {
                                listaAlug.getListaC().remove(j); //Removi o o aluguel da lista
                                listaAlug.setCount(listaAlug.getCount() - 1); //Decremento o count
                                wr.println(listaAlug.getCount());                                
                                break;
                            }
                        }
                        wr.close();
                        //Reescrevendo alugueis
                        wr = new PrintWriter(new FileOutputStream(new File("alugueis.txt"), false));
                        for (int i = 0; i < listaAlug.getListaC().size(); i++) {
                            try {
                                wr.println(listaAlug.getListaC().get(i).getAlugPlaca());
                                wr.println(listaAlug.getListaC().get(i).getAlugCpf());
                                wr.println(listaAlug.getListaC().get(i).getAlugDate());
                                wr.println(listaAlug.getListaC().get(i).getOp());
                            } catch (Exception e) {
                                System.out.println("Erro! File! Alug Pag");
                            }
                        }
                        wr.close();                        
                        //Relatório devolução       
                        outRelatorio = new relatorios(carroDev, carCpf, LocalDate.now(), false);
                        outRelatorioLista = new listaRelatorios(outRelatorio, false);
                    }
                    break;
                case 5: //Relatórios
                    System.out.println("Relatorios\n********************************************");
                    System.out.println("Dia: ");
                    int dia = sc.nextInt();
                    sc.nextLine(); //Scanner workaround    
                    System.out.println("Mes: ");
                    int mes = sc.nextInt();
                    sc.nextLine(); //Scanner workaround    
                    System.out.println("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine(); //Scanner workaround    
                    for (int i = 0; i < outRelatorioLista.getListaRela().size(); i++) {
                        if (outRelatorioLista.getListaRela().get(i).getDataRela().equals(dataR.of(ano, mes, dia))) { //Pegando pela data informada
                            if (outRelatorioLista.getListaRela().get(i).getFlagDevolucao()) { //True == Aluguel
                                System.out.println("Aluguel: " + (i + 1));
                                System.out.println("Carro placa> " + "[" + outRelatorioLista.getListaRela().get(i).getRelaPlaca() + "]" + " Alugado por(CPF)> "
                                        + "[" + outRelatorioLista.getListaRela().get(i).getRelaCpf() + "]");
                                System.out.println("Data Aluguel> " + outRelatorioLista.getListaRela().get(i).getDataRela());
                                System.out.println("********************************************");
                            } else { //False devolução
                                System.out.println("Devolução: " + (i + 1));
                                System.out.println("Carro placa> " + "[" + outRelatorioLista.getListaRela().get(i).getRelaPlaca() + "]" + " Alugado por(CPF)> "
                                        + "[" + outRelatorioLista.getListaRela().get(i).getRelaCpf() + "]");
                                System.out.println("Data Devolução> " + outRelatorioLista.getListaRela().get(i).getDataRela());
                                System.out.println("********************************************");
                            }
                        } else {
                            System.out.println("Não existe relatórios! para a data " + dataR.of(ano, mes, dia));
                        }
                    }
                    break;
                case 6: //Pagar dívida
                    int checkC = 0; //Qtd clientes com divida
                    try {
                        System.out.print("Clientes com dívida: "); //Listando todos clientes com divida
                        for (int i = 0; i < listaC.getListaClientes().size(); i++) { //Perguntar quanto quer pagar
                            if (listaC.getListaClientes().get(i).getDividaCliente() > 0.00f) {
                                System.out.println("\nCliente: " + listaC.getListaClientes().get(i).getNomeCliente());
                                System.out.println("CPF: " + listaC.getListaClientes().get(i).getCpf());
                                System.out.println("Dívida: R$ " + listaC.getListaClientes().get(i).getDividaCliente());
                                checkC++;
                                System.out.println("");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Lista Vazia!");
                        break;
                    }
                    if (checkC > 0) {
                        System.out.println("Selecionar cliente pelo CPF: ");
                        int pagDiv = sc.nextInt();
                        sc.nextLine(); //Workaround
                        System.out.println("Quantidade da dívida a pagar: ");
                        int qtdDiv = sc.nextInt();
                        sc.nextLine(); //Workaround
                        try {
                            for (int i = 0; i < listaC.getListaClientes().size(); i++) {
                                if (listaC.getListaClientes().get(i).getCpf() == pagDiv) {
                                    PrintWriter sr = new PrintWriter(new FileOutputStream(new File(listaC.getListaClientes().get(i).getNomeCliente() + "_" + LocalDate.now().toString() + "_pago.txt"), false));
                                    sr.println("Dívida de R$ " + qtdDiv + " paga!"); //Gera um "recibo"
                                    if (listaC.getListaClientes().get(i).getDividaCliente() - qtdDiv < 0) {
                                        listaC.getListaClientes().get(i).setDividaCliente(0.00f);
                                    } else {
                                        listaC.getListaClientes().get(i).setDividaCliente(listaC.getListaClientes().get(i).getDividaCliente() - qtdDiv);
                                    }
                                    sr.close();
                                    break;
                                }
                            }
                            System.out.println("Dívida paga!");
                        } catch (Exception e) {
                            System.out.println("File! Erro! Pag divida!");
                        }
                        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("clientes.txt"), false));
                        for (int i = 0; i < listaC.getListaClientes().size(); i++) {
                            try { //Rescrevendo no arquivo as alterações                                     
                                wr.println(listaC.getListaClientes().get(i).getNomeCliente());
                                wr.println(listaC.getListaClientes().get(i).getCpf());
                                wr.println(listaC.getListaClientes().get(i).getEnderecoCliente());
                                wr.println(listaC.getListaClientes().get(i).getTelefoneCliente());
                                wr.println(listaC.getListaClientes().get(i).getDividaCliente());
                            } catch (Exception e) {
                                System.out.println("Erro! File! Pag divida!");
                            }
                        }
                        wr.close();
                    }
                    break;
                case 0:
                    System.out.println("Saindo..."); //Fecha a aplicação
                    quit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!quit);
    }
}