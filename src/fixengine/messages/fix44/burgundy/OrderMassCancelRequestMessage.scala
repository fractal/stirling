/*
 * Copyright 2010 the original author or authors.
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
package fixengine.messages.fix44.burgundy

import fixengine.messages.{MessageVisitor, AbstractMessage, MessageHeader, Required, OrderMassCancelRequestMessage => OrderMassCancelRequestMessageTrait}
import fixengine.tags.{OnBehalfOfCompID, ClOrdID, SecurityID, Symbol, TransactTime}
import fixengine.tags.fix43.SecurityIDSource
import fixengine.tags.fix44.MassCancelRequestType

class OrderMassCancelRequestMessage(header: MessageHeader) extends AbstractMessage(header) with OrderMassCancelRequestMessageTrait {
  field(ClOrdID.TAG)
  field(OnBehalfOfCompID.TAG, Required.NO)
  field(MassCancelRequestType.Tag)
  field(Symbol.TAG, Required.NO)
  field(SecurityIDSource.Tag, Required.NO)
  field(SecurityID.TAG, Required.NO)
  field(TransactTime.TAG)
  override def apply(visitor: MessageVisitor) = visitor.visit(this)
}
