/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2016 Marco Hutter - http://www.javagl.de
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
// Copyright 2020. Explore in HMS. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io.v1;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1.GlTF;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io.JacksonUtils;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io.JsonError;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io.JsonErrorConsumers;

/**
 * A class for reading a version 1.0 {@link GlTF} from an input stream
 */
public final class GltfReaderV1
{
    // Note: This class could use GltfReader as a delegate, and could
    // then verify that the glTF has the right version. Right now, it
    // assumes that it is only used for glTF 1.0 inputs.
    
    /**
     * A consumer for {@link JsonError}s that may occur while reading
     * the glTF JSON
     */
    private Consumer<? super JsonError> jsonErrorConsumer = 
        JsonErrorConsumers.createLogging();
    
    /**
     * Creates a new glTF reader
     */
    public GltfReaderV1()
    {
        // Default constructor
    }
    
    /**
     * Set the given consumer to receive {@link JsonError}s that may 
     * occur when the JSON part of the glTF is read
     * 
     * @param jsonErrorConsumer The consumer
     */
    public void setJsonErrorConsumer(
        Consumer<? super JsonError> jsonErrorConsumer)
    {
        this.jsonErrorConsumer = jsonErrorConsumer;
    }
    
    /**
     * Read the {@link GlTF} from the given stream
     *  
     * @param inputStream The input stream
     * @return The {@link GlTF}
     * @throws IOException If an IO error occurs
     */
    public GlTF read(InputStream inputStream) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonUtils.configure(objectMapper, jsonErrorConsumer);
        GlTF gltf = objectMapper.readValue(inputStream, GlTF.class);
        return gltf;
    }
    
}
