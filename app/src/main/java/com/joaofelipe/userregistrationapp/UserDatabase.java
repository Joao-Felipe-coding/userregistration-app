package com.joaofelipe.userregistrationapp;

//Importa as anotações e classses da biblioteca Room e do Android
import android.content.Context; //Classe que representa o contrxto da aplicação (necessário para acessar recurso)
import androidx.room.Database;//Anotações para marcar a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase;  //Classe base que representa o BD

/* Anotações @Database define que a classe representa o BD Room
Ela especifica as entidades (tabelas) que o BD irá conter e a versão do BD*/

@Database(entities= {User.class}, version =1)
public abstract class UserDatabase extends RoomDatabase {
    // Instância única (singleton) do BD no usages
    private static UserDatabase instance;

    // Método abstrato que será implementado pela Room
    // Serve para acessar as operações do BD definidas na USerDao
    public abstract UserDao UserDao();

    // Método que retorna a instância do Bd
    // O usuo do 'synchronized' garante que apenas uma thread possa acessar este método por vez, evitando que duas instâncias do Bd sejam criadas acidentalmente
    public static synchronized UserDatabase getInstance (Context context) {
        // Veridicar se já eiste uma instância de BD
        if (instance == null){
            // Cria a instância do BD usando Room
            // context - Usa o contexto da aplicação para evitarvazamento de memória
            //fallbackToDestructiveMigration - Se houver mudança de versão e nao houver migração, o BD será recriado do zero
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();
        }
        // Retorna a instância criada
        return instance;
    }
}
