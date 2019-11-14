import React from "react";

import { element } from "./reactTools";

const extraTopics: React.FC<{}> = () => element(
    "div",
    {},
    element(
        "div",
        { className: "header" },
        "Extra Topics"
    ),
    [
        "Kotlin Reflection",
        "Annotation Processing/Code Generation",
        "ClassLoaders",
        "Bytecode Injection"
    ].map((text, index) => element(
        "div",
        {
            key: index,
            className: "topic"
        },
        text
    ))
);

export { extraTopics };
