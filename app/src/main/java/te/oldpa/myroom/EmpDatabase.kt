package te.oldpa.myroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Empliyee::class], version = 1)
abstract class EmpDatabase: RoomDatabase(){
    abstract fun empDao(): EmpDao
    companion object{
        private var instance: EmpDatabase?= null
        fun getInstance(ctx: Context): EmpDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(ctx.applicationContext, EmpDatabase::class.java, "emp_database")
                    .fallbackToDestructiveMigration().build()
            }
            return instance!!

            }

        }
    }
