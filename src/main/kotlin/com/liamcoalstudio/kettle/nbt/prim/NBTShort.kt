package com.liamcoalstudio.kettle.nbt.prim

import com.liamcoalstudio.kettle.nbt.NBTTag
import com.liamcoalstudio.kettle.helpers.Buffer
import kotlin.reflect.KClass

class NBTShort(private val value: Short, parent: NBTTag? = null) : NBTTag(parent) {
    override fun<T : NBTTag> isOf(clazz: KClass<T>) = clazz == NBTShort::class

    override fun write(buffer: Buffer) {
        buffer.addByte(id)
        buffer.addNBTString(parent!!.nameOf(this)!!)
        writeInArray(buffer)
    }

    override fun writeInArray(buffer: Buffer) {
        buffer.addShort(value)
    }

    override val id: Byte = 0x02
}