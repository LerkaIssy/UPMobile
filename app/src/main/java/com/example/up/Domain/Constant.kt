package com.example.up.Domain

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constant {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://qjpjlktnpxccvfxvdanp.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InFqcGpsa3RucHhjY3ZmeHZkYW5wIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDIzOTkzODMsImV4cCI6MjA1Nzk3NTM4M30.0TtGpBF5RrhfcxdkSZDqXm1ZzbJ7_WwYVNIOoUqYK8E"
    ) {
        install(Postgrest)
        install(Auth)
        install(Storage)
    }
}