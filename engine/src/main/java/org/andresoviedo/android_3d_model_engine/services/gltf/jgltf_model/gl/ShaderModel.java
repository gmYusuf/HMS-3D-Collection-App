/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2017 Marco Hutter - http://www.javagl.de
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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.gl;

import java.nio.ByteBuffer;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.NamedModelElement;

/**
 * Interface for a shader 
 */
public interface ShaderModel extends NamedModelElement
{
    /**
     * Enumeration of different shader types
     */
    public enum ShaderType 
    {
        /**
         * The vertex shader type
         */
        VERTEX_SHADER,
        
        /**
         * The fragment shader type
         */
        FRAGMENT_SHADER
    }
    
    /**
     * Returns the URI of the shader data
     * 
     * @return The URI
     */
    String getUri();

    /**
     * Returns the actual shader data. This will return a slice of the
     * buffer that is stored internally. Thus, changes to the contents
     * of this buffer will affect this model, but modifications of the 
     * position and limit of the returned buffer will not affect this 
     * model.<br>
     * 
     * @return The shader data
     */
    ByteBuffer getShaderData();
    
    /**
     * Returns the shader source code as a string. This is a convenience
     * function that simply returns the {@link #getShaderData() shader data}
     * as a string.
     * 
     * @return The shader source code
     */
    String getShaderSource();
    
    /**
     * Returns the {@link ShaderType} of this shader
     * 
     * @return The {@link ShaderType}
     */
    ShaderType getShaderType();
    
}