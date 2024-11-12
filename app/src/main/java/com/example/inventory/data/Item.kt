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

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Entity data class represents a single row in the database.
 */
// Kelas `Item` yang mewakili entitas dalam database aplikasi.
// Entitas ini merepresentasikan struktur tabel dalam database Room.
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    // Menandai properti `id` sebagai Primary Key dari tabel.
    // `autoGenerate = true` berarti Room akan secara otomatis menghasilkan nilai unik untuk kolom ini.
    // Nilai default `0` diberikan agar ID diisi otomatis jika tidak ditentukan.
    val id: Int = 0,

    // Nama item. Kolom ini menyimpan deskripsi atau nama produk.
    val name: String,

    // Harga item. Kolom ini menyimpan harga dalam bentuk nilai desimal.
    val price: Double,

    // Jumlah item yang tersedia. Kolom ini menyimpan jumlah stok item.
    val quantity: Int
)
