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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.gl.impl;

import java.util.Objects;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.gl.ProgramModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.gl.ShaderModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.AbstractNamedModelElement;

/**
 * Implementation of a {@link ProgramModel}
 */
public class DefaultProgramModel extends AbstractNamedModelElement
    implements ProgramModel
{
    /**
     * The vertex shader model
     */
    private ShaderModel vertexShaderModel;
    
    /**
     * The fragment shader model
     */
    private ShaderModel fragmentShaderModel;
    
    /**
     * Default constructor
     */
    public DefaultProgramModel()
    {
        // Default constructor
    }
    
    /**
     * Set the vertex {@link ShaderModel}
     * 
     * @param vertexShaderModel The vertex {@link ShaderModel}
     */
    public void setVertexShaderModel(ShaderModel vertexShaderModel)
    {
        this.vertexShaderModel = Objects.requireNonNull(vertexShaderModel,
            "The vertexShaderModel may not be null");
    }

    @Override
    public ShaderModel getVertexShaderModel()
    {
        return vertexShaderModel;
    }
    
    /**
     * Set the fragment {@link ShaderModel}
     * 
     * @param fragmentShaderModel The fragment {@link ShaderModel}
     */
    public void setFragmentShaderModel(ShaderModel fragmentShaderModel)
    {
        this.fragmentShaderModel = Objects.requireNonNull(fragmentShaderModel,
            "The fragmentShaderModel may not be null");
    }

    @Override
    public ShaderModel getFragmentShaderModel()
    {
        return fragmentShaderModel;
    }
}

