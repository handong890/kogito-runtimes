/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.kogito.index.infinispan.protostream;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;
import org.kie.kogito.index.model.NodeInstance;

public class NodeInstanceMarshaller implements MessageMarshaller<NodeInstance> {

    @Override
    public NodeInstance readFrom(ProtoStreamReader reader) throws IOException {
        NodeInstance node = new NodeInstance();
        node.setId(reader.readString("id"));
        node.setName(reader.readString("name"));
        node.setType(reader.readString("type"));
        node.setEnter(reader.readDate("enter"));
        node.setExit(reader.readDate("exit"));
        return node;
    }

    @Override
    public void writeTo(ProtoStreamWriter writer, NodeInstance node) throws IOException {
        writer.writeString("id", node.getId());
        writer.writeString("name", node.getName());
        writer.writeString("type", node.getType());
        writer.writeDate("enter", node.getEnter());
        writer.writeDate("exit", node.getExit());
    }

    @Override
    public Class<? extends NodeInstance> getJavaClass() {
        return NodeInstance.class;
    }

    @Override
    public String getTypeName() {
        return getJavaClass().getName();
    }
}
