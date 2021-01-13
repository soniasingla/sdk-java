/*
 * Copyright 2020-Present The Serverless Workflow Specification Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.serverlessworkflow.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.serverlessworkflow.api.start.Start;

import java.io.IOException;

public class StartDefinitionSerializer extends StdSerializer<Start> {

    public StartDefinitionSerializer() {
        this(Start.class);
    }

    protected StartDefinitionSerializer(Class<Start> t) {
        super(t);
    }

    @Override
    public void serialize(Start start,
                          JsonGenerator gen,
                          SerializerProvider provider) throws IOException {

        if(start != null) {
            if(start.getSchedule() == null) {
                gen.writeBoolean(true);
            } else {
                gen.writeStartObject();
                gen.writeObjectField("schedule",
                        start.getSchedule());
                gen.writeEndObject();
            }
        }
    }
}
