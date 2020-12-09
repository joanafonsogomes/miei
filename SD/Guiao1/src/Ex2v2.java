public class Ex2v2 implements Runnable {
    //VARIAVEIS DE INSTANCIA
    private Counter c;
    private int contar;

    //METODO RUN (Obrigatorio para quando implementa Runnable)
    public void run() {
        for(int i=0; i<10; i++) {
            this.contar++;
        }
    }

    //
    public Ex2v2(Counter nc){
        c = nc;
    }

    public static void main(String args[]){
        int N = 10; //nr de threads

        Thread[] threads = new Thread[N];

        //criar aqui para so ter um contador para as threads
        Counter counter = new Counter(0);

        //criar as threads
        for(int i=0; i<N; i++){
            threads[i] = new Thread(new Ex2v2(counter));
        }

        //iniciar as threads
        for(int i=0; i<N; i++) {
            threads[i].start();
        }

        //esperar que executem
        for(int i=0; i<N; i++){
            try{
                threads[i].join();
            }
            catch(InterruptedException e){}
        }

        System.out.println(counter.get());
    }

}
