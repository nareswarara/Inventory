/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data
import kotlinx.coroutines.flow.Flow

/**
 * Kelas `OfflineItemsRepository` adalah implementasi dari interface `ItemsRepository`.
 * Repository ini menggunakan DAO untuk berkomunikasi dengan database secara offline.
 * DAO menyediakan operasi database seperti insert, update, delete, dan query.
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    /**
     * Mendapatkan semua item dari database sebagai aliran data reaktif (Flow).
     * Memanggil fungsi `getAllItems()` dari DAO untuk mengembalikan daftar item.
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * Mendapatkan satu item berdasarkan ID sebagai aliran data reaktif (Flow).
     * Memanggil fungsi `getItem()` dari DAO untuk mengembalikan data item dengan ID tertentu.
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * Menyisipkan item baru ke dalam database.
     * Fungsi ini berjalan secara asinkron karena menggunakan coroutine.
     * Memanggil fungsi `insert()` dari DAO.
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * Menghapus item dari database.
     * Fungsi ini berjalan secara asinkron dan memanggil fungsi `delete()` dari DAO.
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * Memperbarui data item di dalam database.
     * Fungsi ini berjalan secara asinkron dan memanggil fungsi `update()` dari DAO.
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}