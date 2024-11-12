package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // Deklarasi fungsi abstrak untuk mengakses DAO (Data Access Object).
    abstract fun itemDao(): ItemDao

    companion object {
        // Properti untuk menyimpan instance singleton database.
        // @Volatile memastikan semua thread langsung melihat perubahan pada variabel ini.
        @Volatile
        private var Instance: InventoryDatabase? = null

        /**
         * Fungsi untuk mendapatkan instance database.
         * Menggunakan pola Singleton untuk memastikan hanya satu instance database dibuat.
         */
        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build() // Membuat instance database.
                    .also { Instance = it } // Menyimpan instance ke variabel `Instance`.
            }
        }
    }
}