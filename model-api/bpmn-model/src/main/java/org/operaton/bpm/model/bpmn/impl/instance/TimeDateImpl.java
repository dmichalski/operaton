/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.operaton.bpm.model.bpmn.impl.instance;

import org.operaton.bpm.model.bpmn.instance.Expression;
import org.operaton.bpm.model.bpmn.instance.TimeDate;
import org.operaton.bpm.model.xml.ModelBuilder;
import org.operaton.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.operaton.bpm.model.xml.type.ModelElementTypeBuilder;

import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.operaton.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ELEMENT_TIME_DATE;
import static org.operaton.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN timeDate element of the BPMN tTimerEventDefinition type
 *
 * @author Sebastian Menski
 */
public class TimeDateImpl extends ExpressionImpl implements TimeDate {

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(TimeDate.class, BPMN_ELEMENT_TIME_DATE)
      .namespaceUri(BPMN20_NS)
      .extendsType(Expression.class)
      .instanceProvider(new ModelTypeInstanceProvider<TimeDate>() {
        public TimeDate newInstance(ModelTypeInstanceContext instanceContext) {
          return new TimeDateImpl(instanceContext);
        }
      });

    typeBuilder.build();
  }

  public TimeDateImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

}