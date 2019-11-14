import React from "react";

import { element } from "./reactTools";

export type FCBuilder<T> = (t: T) => React.FC<{}>;
const getpage: (header: React.FC) => FCBuilder<string> = (header: React.FC<{}>) => (text: string): React.FC<{}> => {
    return () => element(
        "div",
        null,
        header({}),
        element(
            "div",
            { className: "subTopic" },
            text
        )
    )
}

export { getpage };
