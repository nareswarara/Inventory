package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Deklarasi interface `ItemDao` sebagai Data Access Object (DAO).
// DAO menyediakan metode untuk berinteraksi dengan database.
@Dao
interface ItemDao {
    // Menambahkan item baru ke dalam database.
    // Jika terjadi konflik (contohnya, duplikat Primary Key), entri akan diabaikan.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (item: Item)

    // Memperbarui entri item yang sudah ada dalam database.
    // Data yang diperbarui harus memiliki Primary Key yang sesuai.
    @Update
    suspend fun update(item: Item)

    // Menghapus entri item dari database.
    @Delete
    suspend fun  delete(item: Item)

    // Mengambil item tertentu dari tabel berdasarkan ID-nya.
    // Hasilnya berupa aliran data reaktif (Flow) yang memungkinkan pembaruan data secara real-time.
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id:Int): Flow<Item>

    // Mengambil semua item dari tabel `items` dan mengurutkannya berdasarkan nama secara ascending.
    // Hasilnya berupa aliran data reaktif (Flow) dalam bentuk daftar (List).
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}