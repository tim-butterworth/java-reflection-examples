import React from 'react';

import { element } from "./reactTools";

const coreJava: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    "Java"
);

const java: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    coreJava({})
);

const reflectJava: React.FC<{}> = () => element(
    "div",
    { className: "mirror" },
    coreJava({})
);

const boringReflection: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    coreJava({}),
    element(
        "div",
        null,
        "Reflection"
    )
);

const coolReflection: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    coreJava({}),
    reflectJava({})
);

export {
    java
    , boringReflection
    , coolReflection
};
