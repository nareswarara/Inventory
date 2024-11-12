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

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository {
    /**
     * Mengambil semua item dari sumber data.
     * @return `Flow<List<Item>>` memungkinkan pengamatan data secara reaktif.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Mengambil item tertentu dari sumber data berdasarkan [id].
     * @param id adalah kunci utama untuk menemukan item.
     * @return `Flow<Item?>` memberikan aliran data yang memperbarui UI saat ada perubahan di database.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Menyisipkan item baru ke dalam sumber data.
     * @param item adalah entitas [Item] yang akan ditambahkan ke database.
     * Fungsi ini menggunakan `suspend` agar dapat berjalan di dalam coroutine.
     */
    suspend fun insertItem(item: Item)

    /**
     * Menghapus item dari sumber data.
     * @param item adalah entitas [Item] yang akan dihapus dari database.
     * Fungsi ini menggunakan `suspend` agar dapat berjalan di dalam coroutine.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Memperbarui data item di sumber data.
     * @param item adalah entitas [Item] yang sudah diperbarui.
     * Fungsi ini menggunakan `suspend` agar dapat berjalan di dalam coroutine.
     */
    suspend fun updateItem(item: Item)
}
