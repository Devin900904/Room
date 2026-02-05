package te.oldpa.myroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface EmpDao {
    @Insert
    fun InsertEmpliyee(empliyee: Empliyee)
    @Update
    fun updateEmpliyee(empliyee: Empliyee)
    @Query("Delete from empliyee where id=:id")
    fun deletEmpliyee(id: Int)
    @Query("Select * from empliyee")
    fun getEmpliyee(): MutableList<Empliyee>


}