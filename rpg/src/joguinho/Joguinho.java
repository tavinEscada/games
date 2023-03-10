package joguinho;

import basededados.FakeBanco;
import complementos.Batalha;
import complementos.Equipamento;
import complementos.Habilidade;
import complementos.Insumo;
import java.util.Scanner;
import java.util.Vector;
import modelo.Heroi;
import modelo.Inimigo;
import java.util.Random;

public class Joguinho {

    public static void cadastraHeroi(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nInforme o nome do Herói: ");
        String nome = entrada.nextLine();
        
        System.out.println("\nDescreva a história do Herói:");
        String historia = entrada.nextLine();
        
        System.out.println("\nInforme a classe do Herói:\n"
                + "1 - Mago; 2 - Guerreiro; 3 - Bárbaro;");
        
        
        int classe = entrada.nextInt();
        
        Vector<Habilidade> habilidadesHeroi = new Vector<>();
        Equipamento equipamentoHeroi = null;
        Vector<Insumo> insumosHeroi = new Vector<>();
        
        Heroi novoH = null;
        
        
        switch(classe){
            case 1:

                habilidadesHeroi.add(new Habilidade(12, "Semente da Destruição", 6, 1));
                habilidadesHeroi.add(new Habilidade(6, "Flecha da Fenix", 2, 1));
                habilidadesHeroi.add(new Habilidade(20, "Bola de Fogo", 14, 1));
                
                
                novoH = new Heroi(1, historia, 1, 0, habilidadesHeroi, equipamentoHeroi, insumosHeroi, nome, 10, 30, 1);
                
                break;
                
            case 2:
                
                habilidadesHeroi.add(new Habilidade(8, "Joelhada Voadora", 2, 1));
                habilidadesHeroi.add(new Habilidade(12, "Rajada de Porrada", 5, 1));
                habilidadesHeroi.add(new Habilidade(20, "Suple da Morte", 10, 1));

                
                novoH = new Heroi(2, historia, 1, 50, habilidadesHeroi, equipamentoHeroi, insumosHeroi, nome, 20, 8, 3);
                break;
                
            case 3:
                
                habilidadesHeroi.add(new Habilidade(8, "Soco Potente", 2, 1));
                habilidadesHeroi.add(new Habilidade(4, "Rasteira", 1, 1));
                habilidadesHeroi.add(new Habilidade(12, "Chutao na Costela", 5, 1));
                
                
                novoH = new Heroi(3, historia, 1, 25, habilidadesHeroi, equipamentoHeroi, insumosHeroi, nome, 30, 18, 3);
                
                break;
          
        }
        
        FakeBanco.insertPersonagem(novoH);
        FakeBanco.insertHeroi(novoH);
        
        System.out.println("\nHerói criado.");
        
    }

    public static void ataqueHeroi(){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nSelecione o herói que vai atacar: ");
        
        
        int num = 1;
        
        Vector<Heroi> herois = FakeBanco.selectAllHerois();
        
        for(Heroi i : herois){
            System.out.println(num + " - " + i);
            num++;
        }
        
        int i = entrada.nextInt();
        i--;
        
        Heroi atacante = herois.get(i);
        
        System.out.println("\nHerói selecionado:");
        System.out.println(atacante+" (Mana restante: "+atacante.getMana()+")");
        
        if(!atacante.getInsumos().isEmpty()){
            System.out.println("Selecine um insumo:");
            int cont = 1;
            for(Insumo ins : atacante.getInsumos()){
                System.out.println(cont+" - " + ins.getNome());
                cont++;
            }
            
            System.out.println(cont+" - Ir para o ataque.");
            int ins = entrada.nextInt();
            
            if(ins != cont){
                Insumo insumoSelec = atacante.getInsumos().get(ins-1);
                
                System.out.println("Vida aumentada em: " + insumoSelec.getPontosVida() + "; Mana aumentada em: " + insumoSelec.getPontosMana());
                
                atacante.setMana(atacante.getMana()+insumoSelec.getPontosMana());
                atacante.setVida(atacante.getVida()+insumoSelec.getPontosVida());
                atacante.getInsumos().remove(ins-1);
                
            }
            
        }
        
        System.out.println("\nSelecione a habilidade ou golpe básico:");

        Vector<Habilidade> habilidades = atacante.getHabilidades();
        num = 1;
        for(Habilidade h : habilidades){
            
            if(atacante.getMana() > h.getQuantMana()){
                System.out.println(num + " - " + h + " (Custo de mana: "+h.getQuantMana()+")");
                num++;
            }
            
        }
        
        System.out.println("4 - Golpe Básico");
        
        int op = entrada.nextInt();
        op--;

        System.out.println("\nHabilidade selecionada:");
        
        if(op == 3){
            System.out.println("Golpe Básico \n");
            
            System.out.println("Selecione o inimigo:");

            int num2 = 1;

            Vector<Inimigo> inimigos = FakeBanco.selectAllInimigos();

            for(Inimigo i3:inimigos){
                System.out.println(num2 + " - " + i3);
                num2++;
            }

            int opcao = entrada.nextInt();
            opcao--;

            Inimigo selec = inimigos.get(opcao);

            System.out.println("\nInimigo selecionado: " + selec);
            
            if(atacante.getEquipamento() == null){
                inimigos.get(opcao).setVida(inimigos.get(opcao).getVida() - atacante.getGolpeBase());
            }else{
                inimigos.get(opcao).setVida(inimigos.get(opcao).getVida() - (atacante.getGolpeBase()+Equipamento.dadoEquipamento(atacante.getEquipamento())));
            }

            

            System.out.println("O dano no " + selec.getNome() + " é igual a " + atacante.getGolpeBase());
            System.out.println("A vida atual do inimigo é " + selec.getVida() + "\n");
            
        }else{
            Habilidade golpe = habilidades.get(op);

            System.out.println(golpe + "\n");

            System.out.println("Selecione o inimigo:\nInimigos: ");

            int num3 = 1;

            Vector<Inimigo> inimigos = FakeBanco.selectAllInimigos();

            for(Inimigo i2:inimigos){
                System.out.println(num3 + " - " + i2);
                num3++;
            }

            int opcao = entrada.nextInt();
            opcao--;

            Inimigo selec = inimigos.get(opcao);

            System.out.println("\nInimigo selecionado: "+selec);


            int danoHeroi = Habilidade.dadoHabilidade(habilidades.get(op));

            inimigos.get(opcao).setVida(inimigos.get(opcao).getVida()-danoHeroi);

            System.out.println("O dano no " + selec.getNome() + " é igual a " + danoHeroi);
            System.out.println("A vida atual do inimigo é " + selec.getVida());
            
            atacante.setMana(atacante.getMana() - golpe.getQuantMana());
            System.out.println("A mana atual do Herói é " + atacante.getMana() + "\n");
            
            if(selec.getVida() <= 0){
                inimigos.remove(selec);
            }
        }
    
    }
    
    public static void ataqueInimigo(){
        
        Random gerador = new Random();
        
        System.out.println("\nO inimigo vai atacar");
        
        Vector<Heroi> herois = FakeBanco.selectAllHerois();
        Vector<Inimigo> inimigos = FakeBanco.selectAllInimigos();
        
        int indiceHeroi = gerador.nextInt(herois.size());
        
        int indiceInimigo = gerador.nextInt(inimigos.size());
        
        herois.get(indiceHeroi).setVida(herois.get(indiceHeroi).getVida() - inimigos.get(indiceInimigo).getGolpeBase());
        
        System.out.println("Quem ataca é o " + inimigos.get(indiceInimigo));
        System.out.println("Heroi selecionado: " + herois.get(indiceHeroi));
        System.out.println("O dano no " + herois.get(indiceHeroi).getNome() + " é igual a " + inimigos.get(indiceInimigo).getGolpeBase());
        
        if(herois.get(indiceHeroi).getVida() <= 0){
            
            System.out.println("\n"+herois.get(indiceHeroi) + " Morreu!!!");
            
            herois.remove(herois.get(indiceHeroi));
        }else{
            System.out.println("\nA vida atual do " + herois.get(indiceHeroi) + " é igual a " +  herois.get(indiceHeroi).getVida());
            
        }

        for(Heroi h:herois){
            h.setMana(h.getMana()+5);
        }
        
        if(herois.isEmpty()){
            System.out.println("Os heróis foram dizimados! Vitória dos inimigos.");
        }
        
        if(inimigos.isEmpty()){
            System.out.println("Os inimigos foram dizimados! Vitória dos heróis.");
        }
        
    }

    public static void realizaBatalha(){
        
        System.out.println("\nIniciando a batalha");
        Vector<Heroi> heroisBatalha = FakeBanco.selectAllHerois();
        Vector<Inimigo> inimigosBatalha = FakeBanco.selectAllInimigos();
        
        while(!FakeBanco.selectAllHerois().isEmpty() && !FakeBanco.selectAllInimigos().isEmpty()){
            ataqueHeroi();
            ataqueInimigo();
        }

        System.out.println("Batalha encerrada.");
        Batalha b = new Batalha(heroisBatalha, inimigosBatalha);
        FakeBanco.insertBatalha(b);
        
    }
    
    public static void loja(){
        Scanner entrada = new Scanner(System.in);
        
        int opcao;
        do{
            System.out.println("\n--Lojinha do Seu Armando--\nDigite: \n 1 - Escolher equipamento;\n 2 - Escolher insumo;\n 3 - Sair da loja.");

            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    Vector<Equipamento> equips = new Vector<>();
                    equips = FakeBanco.selectAllEquipamentos();

                    
                    System.out.println("Equipamentos disponíveis: ");
                    int num = 1;
                    for(Equipamento e : equips){
                        System.out.println(num+" - "+e.getNome()+" - Dano: "+e.getDano()+"; Preço: "+e.getPreco());
                        num++;
                    }
                    
                    int equip = entrada.nextInt();
                    Equipamento e = equips.get(equip-1);
                    
                    System.out.println("Escolha o herói para o qual deseja comprar o item:");
                    
                    Vector<Heroi> herois = FakeBanco.selectAllHerois();
                    int h = 1;
                    for(Heroi heroi : herois){
                        
                        System.out.println(h+" - " + heroi);
                        h++;
                    }
                    int escolha = entrada.nextInt();
                    Heroi heroiSelec = herois.get(escolha-1);
                    
                    if(heroiSelec.getDinheiro() < e.getPreco()){
                        System.out.println("Dinheiro insuficiente.");
                    }else{
                        heroiSelec.setEquipamento(e);
                        heroiSelec.setDinheiro(heroiSelec.getDinheiro()-e.getPreco());
                    }
                    
                    break;
                case 2:
                    Vector<Insumo> insumos = new Vector<>();
                    insumos = FakeBanco.selectAllInsumos();

                    int num2 = 1;
                    System.out.println("Insumos disponíveis: ");
                    
                    for(Insumo i : insumos){
                        System.out.println(num2 +" - "+i.getNome()+": \nPontos de vida: "+i.getPontosVida()+";\nPontos de mana: "+i.getPontosMana()+"\nPreço:"+i.getPreco()+"\n");
                        num2++;
                    }
                    
                    int insumo = entrada.nextInt();
                    Insumo i = insumos.get(insumo-1);
                    
                    System.out.println("Escolha o herói para o qual deseja comprar o item:");
                    
                    herois = FakeBanco.selectAllHerois();
                    
                    num2 = 1;
                    for(Heroi heroi : herois){
                        System.out.println(num2+" - " + heroi);
                        num2++;
                    }
                    escolha = entrada.nextInt();
                    Heroi heroi = herois.get(escolha-1);
                    
                    if(heroi.getDinheiro() < i.getPreco()){
                        System.out.println("Dinheiro insuficiente.");
                    }else{
                        heroi.insertInsumo(i);
                        heroi.setDinheiro(heroi.getDinheiro()-i.getPreco());
                    }

                    break; 
            }
            
        }while(opcao != 3);  
        
    }
    
    public static void main(String[] args) {
        
        FakeBanco.iniciaBanco();
        
        int opcao;
        Scanner entrada = new Scanner(System.in);
            
        do{
            System.out.println("\nDigite:\n 1- Criar novo herói\n 2- Batalha\n 3- Entrar na loja\n 4- Sair do jogo");

            opcao = entrada.nextInt();

            switch(opcao){

                case 1:

                    cadastraHeroi();

                    break;

                case 2:

                    realizaBatalha();

                    break;
                    
                case 3:
                    
                    loja();
                    
                    break;
            }
        }while(opcao != 4);
    }
    
}
