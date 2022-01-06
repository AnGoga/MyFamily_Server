package com.angogasapps.chatservice.key_generators

import com.angogasapps.chatservice.entities.Message
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


class MyGenerator : IdentifierGenerator  {
    override fun generate(session: SharedSessionContractImplementor?, obj: Any?): Serializable? {
        if (obj is Message) {
            val sequenceName = (obj).familyId
            var result: Serializable? = null
            try {
                val c: Connection = session!!.connection()
                val s: Statement = c.createStatement()
                s.execute(
                    "CREATE TABLE IF NOT EXISTS sequences_chat\n" +
                            "     (\n" +
                            "         name VARCHAR(255) NOT NULL UNIQUE,\n" +
                            "         next int8 NOT NULL\n" +
                            "     );"
                )
                s.execute(
                    "DECLARE @current int8\n" +
                            "SET @current = 1\n"+
                            "INSERT INTO sequences_chat (name, next)\n" +
                            "VALUES ('" + sequenceName + "', @current)\n" +
                            "ON CONFLICT (next) DO UPDATE \n" +
                            "@current = next + 1\n" +
                            "next = @current"
                )
                val resultSet: ResultSet = s.executeQuery("SELECT @current")
                if (resultSet.next()) {
                    val nextValue = resultSet.getInt(1)
                    result = "$sequenceName-$nextValue"
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
            return result
        } else {
            return null
        }
    }
}