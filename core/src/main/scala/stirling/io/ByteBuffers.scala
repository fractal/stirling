/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package stirling.io

import java.nio.ByteBuffer

object ByteBuffers {
  def slice(buffer: ByteBuffer, index: Int, length: Int): ByteString = {
    buffer.position(index)

    val slice = new Array[Byte](length)
    buffer.get(slice)

    new ByteString(slice)
  }

  def getAlpha(buffer: ByteBuffer): String = {
    getAlpha(buffer, buffer.remaining)
  }

  def getAlpha(buffer: ByteBuffer, length: Int): String = {
    new String(unwrap(buffer, length), TextFormat.ASCII)
  }

  def unwrap(buffer: ByteBuffer): Array[Byte] = {
    unwrap(buffer, buffer.remaining)
  }

  def unwrap(buffer: ByteBuffer, length: Int): Array[Byte] = {
    val bytes = new Array[Byte](length)

    buffer.get(bytes)

    bytes
  }
}
