public class ClassificacaoDeCrisesHospitalares {

    public static void main(String[] args) {
        Paciente[] pacientes = {
                new Paciente("João", 3, 5),
                new Paciente("Maria", 3, 10),
                new Paciente("Lucas", 5, 2)
        };

        ordenar_pacientes(pacientes);

        System.out.print("Ordem de Atendimento: ");

        imprimir_pacientes(pacientes);
    }

    public static void ordenar_pacientes(Paciente[] pacientes) {
        int tamanho = pacientes.length;
        Paciente aux;

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                boolean precisaTrocar = false;

                if (pacientes[j].gravidade < pacientes[j + 1].gravidade) {
                    precisaTrocar = true;
                } else if (pacientes[j].gravidade == pacientes[j + 1].gravidade) {
                    if (pacientes[j].tempo < pacientes[j + 1].tempo) {
                        precisaTrocar = true;
                    }
                }

                if (precisaTrocar) {
                    aux = pacientes[j];
                    pacientes[j] = pacientes[j + 1];
                    pacientes[j + 1] = aux;
                }
            }
        }
    }

    public static void imprimir_pacientes(Paciente[] pacientes) {
        for (int i = 0; i < pacientes.length; i++) {
            System.out.print(pacientes[i].nome);
            if (i < pacientes.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

class Paciente {
    String nome;
    int gravidade;
    int tempo;

    public Paciente(String nome, int gravidade, int tempo) {
        this.nome = nome;
        this.gravidade = gravidade;
        this.tempo = tempo;
    }
}