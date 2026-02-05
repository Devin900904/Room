package te.oldpa.myroom

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "empliyee")

data class Empliyee(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "EmpName")
    val name:String,
    @ColumnInfo(name = "EmpAddress")
    val Address:String,
    @ColumnInfo(name = "EmExperience")
    val Experience: String,
    @ColumnInfo(name = "EmpDepartment")
    val Department:String







)